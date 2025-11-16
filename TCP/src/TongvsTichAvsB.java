/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author Acer
 */
public class TongvsTichAvsB {
    public static void main (String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN900;vV5yNAWw";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt();
        int b = in.readInt();
        System.out.println(a);
        System.out.println(b);
        int tong = a + b;
        int tich = a * b;
        System.out.println(tong);
        System.out.println(tich);
        out.writeInt(tong);
        out.writeInt(tich);
        in.close();
        out.close();
        socket.close();
    }
}
