/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.net.*;
import java.util.*;
import TCP.Student;
/**
 *
 * @author Acer
 */
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String code = "B21DCCN699,THD23f";
        out.writeObject(code);
        out.flush();
        
        Student student = (Student) in.readObject();
        float x = student.getGpa();
        if (x >= 3.7){
            student.setGpaLetterString("A");
        }else if (x >= 3.0){
            student.setGpaLetterString("B");
        }else if (x >= 2.0){
            student.setGpaLetterString("C");
        }else if(x >= 1.0){
            student.setGpaLetterString("D");
        }else{
            student.setGpaLetterString("F");
        }
        out.writeObject(student);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}

/*
[Mã câu hỏi (qCode): j5ELZdmS].  Một chương trình server cho phép kết nối qua giao thức TCP 
tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một 
chương 
trình 
client 
tương 
tác 
với 
server 
sử 
dụng 
tượng(ObjectOutputStream/ObjectInputStream) theo kịch bản dưới đây: 
các 
luồng 
Biết lớp TCP.Student gồm các thuộc tính (id int,code String, gpa float, gpaLetter String) và  
private static final long serialVersionUID = 20151107; 
a. 
đối 
Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng 
"studentCode;qCode". Ví dụ: "B15DCCN999;1D059A3F" 
b. 
Nhận một đối tượng là thể hiện của lớp TCP.Student từ server 
c. 
Chuyển đổi giá trị điểm số gpa của đối tượng nhận được sang dạng điểm chữ và gán cho 
gpaLetter.  Nguyên tắc chuyển đổi 
i. 
ii. 
iii. 
iv. 
v. 
3.7 – 4 -> A 
3.0 – 3.7 -> B 
2.0 – 3.0 -> C 
1.0 – 2.0 -> D 
0 – 1.0 -> F 
d.     Gửi đối tượng đã được xử lý ở trên lên server. 
e.     Đóng kết nối và kết thúc chương trình 
*/