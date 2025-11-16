/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */

import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN699;MuGaU3U0";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1]; 
        //Đếm
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): MuGaU3U0].  Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client tương tác với server kịch bản dưới đây:
a.	Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”
b.	Nhận thông điệp từ server theo định dạng “requestId; data” 
-	requestId là một chuỗi ngẫu nhiên duy nhất
-	data là chuỗi dữ liệu đầu vào cần xử lý
Ex: “requestId;Qnc8d5x78aldSGWWmaAAjyg3”
c.	Tìm kiếm ký tự xuất hiện nhiều nhất trong chuỗi và gửi lên server theo định dạng “requestId;ký tự xuất hiện nhiều nhất: các vị trí xuất hiện ký tự đó” 
ví dụ: “requestId;8:4,9,”
d.	Đóng socket và kết thúc chương trình
*/

