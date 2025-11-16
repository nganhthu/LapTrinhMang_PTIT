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
public class TongTBCPhuongSai {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN699;Gcf1ToDt";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        int []a = new int[n];
        for (int i = 0; i<n; i++){
            a[i] = in.readInt();
        }
        int tong = 0;
        for (int i = 0; i< n;i++){
            tong += a[i];
        }
        float tbc = (float)tong/n;
        float tmp = 0;
        for (int i = 0; i<n; i++){
            tmp += (float)(a[i]-tbc)*(a[i]-tbc);
        }
        float psai = (float)tmp/n;
        out.writeInt(tong);
        out.flush();
        out.writeFloat(tbc);
        out.flush();
        out.writeFloat(psai);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
