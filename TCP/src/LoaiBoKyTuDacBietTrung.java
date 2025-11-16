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
public class LoaiBoKyTuDacBietTrung {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String code = "B21DCCN699;tGYlr3TY";
        out.write(code);
        out.newLine();
        out.flush();
        
        
        //Nhan
        String s = in.readLine();
        System.out.println(s);
        
        int []cnt = new int[1005];
        for(char x : s.toCharArray()){
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        
        String ans = "";
        for(char x : s.toCharArray()){
            if(cnt[x] > 0){
                ans += x;
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        
        out.write(ans);
        out.newLine();
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
