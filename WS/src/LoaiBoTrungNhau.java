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

public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String  msv ="B21DCCN699", qCode ="agsag";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        List<Integer>ans = new java.util.ArrayList<>();
        int[]cnt = new int[10005];
        for(int x : a){
            cnt[x]++;
        }
        for(int x : a){
            if(cnt[x] > 0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        port.submitDataIntArray(msv, qCode, ans);
    }
}
