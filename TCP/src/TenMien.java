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
public class TenMien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN662;o5Pr6bN5";
        out.write(code);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        System.out.println(s);
        
        String[]ans = s.trim().split(",");
        
        StringBuilder res = new StringBuilder();
        for(String d : ans){
            d = d.trim();
            if(d.length()>=4 && d.substring(d.length()-4).equals(".edu")){
                res.append(d).append(", ");       
            }
        }
        System.out.println(res);
        out.write(res.toString());
        out.newLine();
        out.flush();
        
        
        in.close();
        out.close();
        socket.close();
    }
}
