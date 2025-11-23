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

public class DemSoLanXuatHien {
    public static void main(String[] args) throws Exception{
        String msv ="B21DCCN699", qCode = "hssfd";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        Collections.sort(a);
        List<String>ans = new java.util.ArrayList<>();
        int[]cnt = new int[10005];
        for(int x : a){
            cnt[x] ++;
        }
        for(int i = 0; i<a.size();i++){
            String res ="";
            if(cnt[a.get(i)] > 0){
                res += String.format("%d, %d", a.get(i), cnt[a.get(i)]);
                ans.add(res);
                //gan ve 0 de k lap
                cnt[a.get(i)] = 0;
            }
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
