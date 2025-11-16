/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Acer
 */
public class DaoNguocDoanDaiK {
    public static void main (String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN699;HHUHyy78";
        out.writeUTF(code);
        out.flush();
        int k = in.readInt();
        String s = in.readUTF();
        ArrayList<Integer> a = new ArrayList<>();
        String []sd = s.trim().split(",");
        for(String x : sd){
            a.add(Integer.parseInt(x.trim()));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int b = a.size();
        for(int i=0; i<b; i++){
            int j = Math.min(i+k-1, b-1);
            for(int o = j; o >= i; o--){
                ans.add(a.get(o));
            }
        }
        String res ="";
        for(int i = 0; i<b; i++){
            res += String.format("%d", ans.get(i));
            if (i!= b-1) res += ",";
        }
        System.out.println(res);
        out.writeUTF(res);
        out.flush();
        in.close();
        out.close();
        socket.close();
        
        
    }
}
