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
import RMI.DataService;

public class ThamLamXepXu {
    public static void main(String[] args) throws Exception {
        // a) Nhận amount từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");

        String studentCode = "B21DCCN699";
        String qCode = "bq8BA9wN";

        Object obj = sv.requestData(studentCode, qCode);
        // Server có thể trả về Integer/Long/Double... nên ép về Number an toàn rồi lấy intValue()
        if (!(obj instanceof Number)) {
            throw new IllegalStateException("Dữ liệu nhận không phải số: " + obj);
        }
        int amount = ((Number) obj).intValue();
        System.out.println("amount = " + amount);

        // b) Thuật toán xếp đồng xu (mệnh giá cố định 10,5,2,1) – tham lam tối ưu cho hệ này
        int[] coins = {10, 5, 2, 1}; // sắp xếp giảm dần
        List<Integer> used = new ArrayList<>();
        int remain = amount;

        if (amount <= 0) {
            // Không hợp lệ theo đề (yêu cầu số nguyên dương) -> coi như không thể đạt
            String res = "-1";
            System.out.println(res);
            sv.submitData(studentCode, qCode, res);
            System.out.println("Đã submit: " + res);
            return;
        }

        for (int c : coins) {
            while (remain >= c) {
                remain -= c;
                used.add(c);
            }
        }

        String res;
        if (remain != 0) {
            // Với bộ {1,2,5,10} thực tế sẽ luôn đạt, nhưng vẫn xử lý trường hợp bất thường
            res = "-1";
        } else {
            // Kết quả dạng: "<số_đồng>; 10,5,2,1"
            StringBuilder list = new StringBuilder();
            for (int i = 0; i < used.size(); i++) {
                if (i > 0) list.append(",");
                list.append(used.get(i));
            }
            res = used.size() + "; " + list.toString();
        }

        System.out.println("Kết quả: " + res);

        // c) Gửi chuỗi kết quả về server
        sv.submitData(studentCode, qCode, res);

        // d) Kết thúc
        System.out.println("Đã submit kết quả, client kết thúc.");
    }
}

/*
[Mã câu hỏi (qCode): ErHT5hFn].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một số nguyên dương amount từ server, đại diện cho số tiền cần đạt được.
b. Sử dụng thuật toán xếp đồng xu với các mệnh giá cố định [1, 2, 5, 10] để xác định số lượng đồng xu tối thiểu cần thiết để đạt được số tiền amount. Nếu không thể đạt được số tiền đó với các mệnh giá hiện có, trả về -1.
Ví dụ: Với amount = 18 và mệnh giá đồng xu cố định [1, 2, 5, 10], kết quả là 4 (18 = 10 + 5 + 2 + 1). Chuỗi cần gửi lên server là: 4; 10,5,2,1
c. Triệu gọi phương thức submitData để gửi chuỗi (kiểu String) chứa kết quả số lượng đồng xu tối thiểu và giá trị các đồng xu tương ứng  trở lại server.
d. Kết thúc chương trình client.
*/
