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

public class TongTichHieuUCLNBCNN {
    /*
    public static int UCLN(int a, int b){
        while (b!=0) {
            int tmp = b%a;
            a = b;
            b = tmp;
        }
        return a;
    }*/
    public static int UCLN(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main (String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN699;qef8920t";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt();
        int b = in.readInt();
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        int ucln = UCLN(a, b);
        int bcnn = (int)(a*b)/ucln;
        out.writeInt(tong);
        out.writeInt(hieu);
        out.writeInt(tich);
        out.writeInt(ucln);
        out.writeInt(bcnn);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
