/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import java.util.*;
import vn.medianews.*;

public class XapXepChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode = "agkfag";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<Integer>chan = new ArrayList<>();
        List<Integer>le = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();
        for(int x : a){
            if(x%2==0){
                chan.add(x);
            }else{
                le.add(x);
            }
        }
        int k = Math.min(chan.size(), le.size());
        for(int i = 0; i<k; i++){
            ans.add(chan.get(i));
            ans.add(le.get(i));
        }
        int k1 = chan.size() - k;
        int k2 = le.size() -k;
        if(k1>0){
            for(int i = k; i<chan.size(); i++){
                ans.add(chan.get(i));
            }
        }
        if(k2>0){
            for(int i = k; i<le.size(); i++){
                ans.add(le.get(i));
            }
        }
        port.submitDataIntArray(msv, qCode, ans);
    }
}
