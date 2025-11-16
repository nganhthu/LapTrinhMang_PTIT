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
public class ChuoiNhiPhan {
    public static void main (String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        /*DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code  = "B21DCCN017;VILJTN2Q";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt();
        System.out.println(a);
        String s = Integer.toBinaryString(a);
        System.out.println(s);
        */
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN017;VILJTN2Q";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        String s = Integer.toBinaryString(n);
        
        out.writeUTF(s);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
