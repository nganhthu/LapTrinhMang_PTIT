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
public class TongCacSoNguyenTo {
    public static int check(int n) {
        if(n <=1) return 0;
        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code  ="B21DCCN699;ZRFRsEcM";
        out.write(code.getBytes());
        out.flush();
        
        //
        byte[] u = new byte[1024];
        int y = in.read(u);
        String s = new String(u,0,y);
        System.out.println(s);
        
        //
        ArrayList<Integer>ans = new ArrayList<>();
        String []res = s.trim().split(",");
        for(String x : res){
            ans.add(Integer.parseInt(x));
        }
        
        int tong = 0;
        for(int x : ans){
            if(check(x)==1) tong += x;
        }
        
        String ans1 = String.format("%d", tong);
        out.write(ans1.getBytes());
        out.flush();
        
        //
        in.close();
        out.close();
        socket.close();
    }
}
