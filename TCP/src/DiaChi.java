/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import TCP.Address;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Acer
 */
public class DiaChi {
    
    //Viet Hoa chu dau, chu sau viet thuong
    public static String ChuanHoa0(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    //Loai bo ky tu dac biet ma dia chi
    public static String Loai0(String s){
        String ans = "";
        for(char x : s.toCharArray()){
            if(Character.isAlphabetic(x) || Character.isDigit(x)){
                ans += String.format("%c", x);
            }
        }
        return ans;
    }
    //ChuanHoaDiaChi
    public static String ChuanHoa1(String s){
        String ans = "";
        String []tmp = s.trim().split("\\s+");
        for(String x: tmp){
            ans += ChuanHoa0(Loai0(x)) + " ";
        }
        return ans;
    }
    
    //LoaiPortalCode
    public static String LoaiBo1(String s){
        String ans = "";
        for(char x : s.toCharArray()){
            if(Character.isDigit(x) || x == '-'){
                ans += String.format("%c", x);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) throws EOFException, ClassNotFoundException, IOException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String code = "B21DCCN699;89DSGsg";
        out.writeObject(code);
        out.flush();
        
        Address ad = (Address) in.readObject();
        System.out.println(ad);
        ad.setAddressLine(ChuanHoa1(ad.getAddressLine()));
        ad.setPostalCode(LoaiBo1(ad.getPostalCode()));
        
        System.out.println(ad);
        out.writeObject(ad);
        out.flush();
        
        in.close();
        out.close();
        socket.close();
        
        
    }
}


/*
BÀI 8. ĐỊA CHỈ KHÁCH HÀNG
[Mã câu hỏi (qCode): XtWjagNp].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 809 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectOutputStream/ObjectInputStream) để gửi/nhận và chuẩn hóa thông tin địa chỉ của khách hàng.
Biết rằng lớp TCP.Address có các thuộc tính (id int, code String, addressLine String, city String, postalCode String) và trường dữ liệu private static final long serialVersionUID = 20180801L.
a. Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;A1B2C3D4"
b. Nhận một đối tượng là thể hiện của lớp TCP.Address từ server. Thực hiện chuẩn hóa thông tin addressLine bằng cách:
•	Chuẩn hóa addressLine: Viết hoa chữ cái đầu mỗi từ, in thường các chữ còn lại, loại bỏ ký tự đặc biệt và khoảng trắng thừa (ví dụ: "123 nguyen!!! van cu" → "123 Nguyen Van Cu") 
•	Chuẩn hóa postalCode: Chỉ giữ lại số và ký tự "-" ví dụ: "123-456"
c. Gửi đối tượng đã được chuẩn hóa thông tin địa chỉ lên server.
d. Đóng kết nối và kết thúc chương trình.
*/