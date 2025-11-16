/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class SoLanXuatHien {
    public static void main(String[] args) throws Exception {
        // a) Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");

        String studentCode = "B21DCCN699";
        String qCode = "VmwXtwQt";

        String s = sv.requestCharacter(studentCode, qCode);
        System.out.println("Server trả về: " + s);

        // Bóc cặp dấu ngoặc kép nếu có dạng "Chuỗi đầu vào"
        String input = s;
        if (input != null && input.length() >= 2
                && input.charAt(0) == '"' && input.charAt(input.length() - 1) == '"') {
            input = input.substring(1, input.length() - 1);
        }
        System.out.println("Chuỗi đầu vào (đã bóc \" \"): " + input);

        // b) Đếm tần số xuất hiện theo thứ tự xuất hiện lần đầu
        //    LinkedHashMap giữ nguyên thứ tự key được gặp lần đầu
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Ghép kết quả dạng <Ký tự><Số lần>
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            sb.append(e.getKey()).append(e.getValue());
        }
        String res = sb.toString();
        System.out.println("Kết quả: " + res);

        // c) Gửi kết quả lại server
        sv.submitCharacter(studentCode, qCode, res);

        // d) Kết thúc
        System.out.println("Đã submit kết quả, client kết thúc.");
    }
}

/*
[Mã câu hỏi (qCode): VmwXtwQt].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý chuỗi.
Giao diện từ xa:
public interface CharacterService extends Remote {
public String requestCharacter(String studentCode, String qCode) throws RemoteException;
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
Trong đó:
•	Interface CharacterService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với RegistryServer với tên là: RMICharacterService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với chuỗi được nhận từ RMI Server:
a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server với định dạng: "Chuỗi đầu vào".
b. Thực hiện đếm tần số xuất hiện của mỗi ký tự trong chuỗi đầu vào và tạo ra chuỗi kết quả theo định dạng <Ký tự><Số lần xuất hiện>, sắp xếp theo thứ tự xuất hiện của các ký tự trong chuỗi.
Ví dụ: Chuỗi đầu vào "AAABBC" -> Kết quả: "A3B2C1".
c. Triệu gọi phương thức submitCharacter để gửi chuỗi kết quả trở lại server.
d. Kết thúc chương trình client.
*/