/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */




import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import RMI.CharacterService;

public class TrichKeyValue {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");

        String studentCode = "B21DCCN699", qCode = "2UVWzI6q";
        String raw = sv.requestCharacter(studentCode, qCode);

        // Bóc "..." (nếu có) rồi trim
        String json = raw;
        if (json != null && json.length() >= 2 && json.charAt(0) == '"' && json.charAt(json.length()-1) == '"')
            json = json.substring(1, json.length()-1);
        json = json.trim();

        // Parse object phẳng: {"k":"v", "a": 25, "b": true}
        List<String> pairs = new ArrayList<>();
        int i = 0, n = json.length();
        if (n == 0 || json.charAt(0) != '{') throw new IllegalArgumentException("Không phải JSON object");
        i++; // skip '{'
        while (i < n) {
            i = skipWs(json, i);
            if (i < n && json.charAt(i) == '}') break;

            // key (string)
            if (json.charAt(i) != '"') throw new IllegalArgumentException("Key phải bắt đầu bằng \"");
            String key = readJsonString(json, i);
            i = nextIdx;                          // cập nhật từ readJsonString()
            i = skipWs(json, i);
            if (json.charAt(i++) != ':') throw new IllegalArgumentException("Thiếu ':'");
            i = skipWs(json, i);

            // value (string hoặc token đến , hoặc })
            String val;
            if (json.charAt(i) == '"') {          // string
                val = readJsonString(json, i);
                i = nextIdx;
            } else {                               // số/true/false/null
                int start = i;
                while (i < n && json.charAt(i) != ',' && json.charAt(i) != '}') i++;
                val = json.substring(start, i).trim();
            }
            pairs.add(key + ": " + val);

            i = skipWs(json, i);
            if (i < n && json.charAt(i) == ',') { i++; continue; }
            if (i < n && json.charAt(i) == '}') break;
        }

        // even; odd
        StringBuilder even = new StringBuilder(), odd = new StringBuilder();
        for (int k = 0; k < pairs.size(); k++) {
            (k % 2 == 0 ? even : odd).append((k % 2 == 0 ? even : odd).length() > 0 ? ", " : "").append(pairs.get(k));
        }
        String result = even + "; " + odd;
        System.out.println(result);
        sv.submitCharacter(studentCode, qCode, result);
    }

    // --- helpers nhỏ gọn ---
    private static int nextIdx; // vị trí sau dấu " đóng (được set bởi readJsonString)

    private static String readJsonString(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (s.charAt(i++) != '"') throw new IllegalArgumentException();
        while (i < n) {
            char c = s.charAt(i++);
            if (c == '\\') {                       // escape cơ bản
                if (i >= n) break;
                char e = s.charAt(i++);
                switch (e) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case 'n': sb.append('\n'); break;
                    case 'r': sb.append('\r'); break;
                    case 't': sb.append('\t'); break;
                    case 'u':
                        if (i + 4 > n) throw new IllegalArgumentException("\\u thiếu 4 hex");
                        sb.append((char) Integer.parseInt(s.substring(i, i+4), 16));
                        i += 4; break;
                    default: sb.append(e);
                }
            } else if (c == '"') { nextIdx = i; return sb.toString(); }
            else sb.append(c);
        }
        throw new IllegalArgumentException("Chuỗi JSON chưa đóng dấu \"");
    }

    private static int skipWs(String s, int i) {
        int n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return i;
    }
}

/*
[Mã câu hỏi (qCode): 2UVWzI6q].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý chuỗi.
Giao diện từ xa:
public interface CharacterService extends Remote {
public String requestCharacter(String studentCode, String qCode) throws RemoteException;
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
Trong đó:
•	Interface CharacterService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với RegistryServer với tên là: RMICharacterService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với chuỗi được nhận từ RMI Server:
a. Triệu gọi phương thức requestCharacter để nhận chuỗi JSON ngẫu nhiên từ server với định dạng: "Chuỗi JSON đầu vào".
b. Phân tích cú pháp chuỗi JSON nhận được và trích xuất các cặp key: value dựa trên vị trí của chúng:
•	Các cặp key: value ở vị trí chẵn sẽ được đưa vào chuỗi đầu tiên.
•	Các cặp key: value ở vị trí lẻ sẽ được đưa vào chuỗi thứ hai.
•	Hai chuỗi kết quả sẽ được nối với nhau và phân tách bởi dấu ;
Ví dụ: Chuỗi JSON ban đầu {"name": "Alice", "age": 25, "city": "Wonderland", "country": "Fictionland"} -> Kết quả trích xuất: "name: Alice, city: Wonderland; age: 25, country: Fictionland".
c. Triệu gọi phương thức submitCharacter để gửi chuỗi kết quả trích xuất đã được định dạng trở lại server.
d. Kết thúc chương trình client.
*/