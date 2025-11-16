import java.util.*;
import java.io.*;
import java.net.*;
import TCP.Laptop;

public class SanPham{
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        String code = "B21DCCN017;nKWkVV2b";
        out.writeObject(code);
        out.flush();
        
        //Nhan
        Laptop laptop = (Laptop) in.readObject();
        System.out.println("San pham ban dau" + laptop);
        //Chuan toan ten
        String name = laptop.getName();
        String[] word = name.trim().split("\\s+");
        if (word.length > 1){
            String tmp = word[0];
            word[0] = word[word.length-1];
            word[word.length-1] = tmp;
        }
        String tmpx = "";
        for(String x : word){
            tmpx += x + " ";
        }
        laptop.setName(tmpx.trim());
        
        //Chuan hoa ma
        String tmp1 = laptop.getQuantity()+ "";
        String tmp2 = "";
        for(int i = tmp1.length()-1; i>=0; i--){
            tmp2 += String.valueOf(tmp1.charAt(i));
       
        }
        laptop.setQuantity(Integer.parseInt(tmp2));
        
        //sp sau
        System.out.println(laptop);
        out.writeObject(laptop);
        out.flush();
        in.close();
        out.close();
        socket.close();
        
        
        
        
        
    }
}