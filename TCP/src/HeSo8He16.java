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
public class HeSo8He16 {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN699;GD24ty3";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        String oct = Integer.toOctalString(n);
        String hex = Integer.toHexString(n).toUpperCase();
        out.writeUTF(oct + ";" + hex);
        out.flush();
        in.close();
        out.close();
        socket.close();
        
    }
}
