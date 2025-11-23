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

public class He2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN676", qCode = "uQPjTDIa";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x : a){
            String bi = Integer.toBinaryString(x);
            ans.add(bi);
        }
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
              
                
    }
}
