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
public class DoiChieuvaBienThien {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN699;DGSG12";
        out.writeUTF(code);
        out.flush();
        String s = in.readUTF();
        ArrayList<Integer> a = new ArrayList<>();
        String []st = s.trim().split(",");
        for(String x : st){
            a.get(Integer.parseInt(x.trim()));
        }
        int bthien = 0;
        int n = a.size();
        for(int i=0; i<n; i++){
            bthien += Math.abs(a.get(i)-a.get(i+1));
        }
        int dchieu = 0;
        for(int i=1; i<n; i++){
            if((a.get(i)>a.get(i-1)&&a.get(i)>a.get(i+1))||(a.get(i)<a.get(i-1)&&a.get(i)<a.get(i+1))){
                dchieu ++;
            }
        }
        out.writeInt(bthien);
        out.flush();
        out.writeInt(dchieu);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
