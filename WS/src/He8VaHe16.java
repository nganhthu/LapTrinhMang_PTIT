/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import vn.medianews.*;
import java.util.*;

public class He8VaHe16 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN576", qCode = "otEBFi0I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x : a){
            String bp = Integer.toOctalString(x), hex = Integer.toHexString(x).toUpperCase();
            ans.add(bp + "|" + hex);
        }
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
        
    }
}
