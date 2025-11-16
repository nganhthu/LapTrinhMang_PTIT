/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class Cong2SoNhiPhan{
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN699;OBZPvOb3";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy chuỗi thực tế từ gói nhận (cắt \0 thừa)
        String st = new String(dpNhan.getData(), 0, dpNhan.getLength()).trim();
        System.out.println("Nhận từ server: " + st);

        // Chuỗi dạng: requestId;b1,b2
        st = st.replace(",", " ").replace(";", " ");
        String[] tmp = st.trim().split("\\s+");

        String rqID = tmp[0];
        long b1 = Long.parseLong(tmp[1], 2);
        long b2 = Long.parseLong(tmp[2], 2);
        long tong = b1 + b2;

        // c. Gửi lại theo format: rqID;sum
        String ans = rqID + ";" + tong;
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
        System.out.println("Gửi lại: " + ans);

        // d. Đóng socket
        socket.close();
    }
}
/*
[Mã câu hỏi (qCode): OBZPvOb3].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.

b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130 
d. Đóng socket và kết thúc chương trình.
*/
