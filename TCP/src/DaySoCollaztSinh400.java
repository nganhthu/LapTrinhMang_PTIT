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
public class DaySoCollaztSinh400{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        String code = "B21DCCN596;J0czildW";
        out.write(code.getBytes());
        out.flush();
        
        //tao luong
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        
        int n = Integer.parseInt(s);
        ArrayList<Integer>ans = new ArrayList<>();
        while(n != 1){
            ans.add(n);
            if(n%2 == 1){
                n = 3 * n + 1;
            }else if (n%2 == 0){
                n /= 2;
            }
        }
        ans.add(1);
        int S = ans.size();
        String res = "";
        for(int i = 0; i < S - 1; i++) res += String.format("%d ", ans.get(i));
        res += String.format("%d; %d", ans.get(S - 1), S);
        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}