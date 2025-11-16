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
public class DecimalToBinary {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode = "L3zWe3ge"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a) ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}

