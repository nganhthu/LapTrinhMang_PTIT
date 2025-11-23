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


public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699",qCode ="jkghasg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int) port.getDataDouble(msv, qCode);
        List<Integer>ans = new java.util.ArrayList<>();
        for (int i = 1; i<=n; i++){
            if(n % i ==0){
                ans.add(i);
            }
        }
        ans.add(0, ans.size());
        port.submitDataIntArray(msv, qCode, ans);
    }
}
