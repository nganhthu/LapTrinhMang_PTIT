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
public class MatMaCaesar {
    public static void main (String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN014;KwTH9Tos";
        out.writeUTF(code);
        out.flush();
        /*
        String x = in.readUTF();
        int s = in.readInt();
        String ans = "";
        for (char i: x.toCharArray()){
            if (Character.isLetter(i)){
                char base = Character.isUpperCase(i)?'A':'a';
                i = (char) (((i-base-s+26)%26)+base); 
            }
            ans += i;
        }*/
        String s = in.readUTF();
        int k = in.readInt();
        String ans = "";
        for(char i : s.toCharArray()){
            if(Character.isLetter(i)){
                char base = Character.isUpperCase(i)?'A' : 'a';
                i = (char) (((i-base-k+26)%26)+base);
            }
            ans += i;
        }
        out.writeUTF(ans);
        System.out.println(ans);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
