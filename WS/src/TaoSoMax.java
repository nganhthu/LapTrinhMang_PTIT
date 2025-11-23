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

public class TaoSoMax {
    public static void main(String[] args){
        String msv ="B21DCN699", qCode="oihio";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<String>ans = new java.util.ArrayList<>();
        for(int x:a){
            ans.add(x+"");
        }
        Collections.sort(ans);
        String ans1 ="";
        for(String x : ans){
            ans1 += x + ans1;
        }
        port.submitDataString(msv, qCode, ans1);
    }
}
