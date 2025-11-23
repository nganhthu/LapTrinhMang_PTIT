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

public class Ptichthuasongto {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699",qCode ="bagas";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<String>ans = new java.util.ArrayList<>();
        for(int x : a){
            String res = "";
            for(int i=2; i*i <= x;i++){
                while(x%i==0){
                    x /= i;
                    res += String.format("%d, ", i);
                }
            }
            if(x>1){
                res += String.format("%d, ", x);
            }
            res = res.trim();
            res = res.substring(0, res.length()-1);
            ans.add(res);
            System.out.println(ans);
        }
        port.submitDataStringArray(msv, qCode, ans);
                
    }
}
