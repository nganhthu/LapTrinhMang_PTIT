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
public class DayConTangDaiNhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN017;UZJUJpRa";
        out.write(code.getBytes());
        out.flush();
        
        //Nhan
        byte[] buffer = new byte[1024];
        int read = in.read(buffer);
        String s = new String(buffer, 0, read);
        System.out.println(s);
        
        in.close();
        out.close();
        socket.close();
        
    }
    
}
