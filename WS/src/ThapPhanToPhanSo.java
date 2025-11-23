/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import vn.medianews.*;
import java.util.*;

/**
 *
 * @author Acer
 */
public class ThapPhanToPhanSo {
    public static int GCD(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode ="aggha";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        //lam tron 2 so thap phan
        double a1 = Math.round(a*100)/100.0;
        //tu, mau
        int mau = 100;
        int tu = (int) (a1*100);
        int tmp = GCD(tu, mau);
        mau /= tmp;
        tu /= tmp;
        List<Integer>ans = new java.util.ArrayList<>();
        ans.add(tu); ans.add(mau);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
