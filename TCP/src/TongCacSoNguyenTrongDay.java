/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Acer
 */
public class TongCacSoNguyenTrongDay {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN576;Cs6Cr2OQ";
        out.write(code.getBytes());
        out.flush();
        
        //
        byte[] x= new byte[1024];
        int y = in.read(x);
        String s = new String(x,0,y);
        System.out.println(s);
        
        String []res = s.trim().split("\\|");
        ArrayList<Integer>tmp = new ArrayList<>();
        for (String z : res) {
            tmp.add(Integer.parseInt(z));
        }
        int tong = 0;
        for(int u: tmp){
            tong += u;
        }
        String ans = String.format("%d", tong);
        System.out.println(tong);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
