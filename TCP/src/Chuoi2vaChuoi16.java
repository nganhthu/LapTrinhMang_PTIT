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
public class Chuoi2vaChuoi16 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN397;hKVV6PYZ";
        out.writeUTF(code);
        out.flush();
        /*int a = in.readInt();
        System.out.println(a);
        String nhi = Integer.toBinaryString(a);
        String hex = Integer.toHexString(a).toUpperCase();
        System.out.println(nhi + ";" +hex);*/
        int n = in.readInt();
        String nhi = Integer.toBinaryString(n);
        String hex = Integer.toHexString(n).toUpperCase();
        System.out.println(nhi + ";" + hex);
        out.writeUTF(nhi + ";" + hex);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
