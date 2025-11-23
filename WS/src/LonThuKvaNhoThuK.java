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

public class LonThuKvaNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21dccn699",qCode ="agdg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int K = a.get(0);
        System.out.println(a);
        a.remove(0);
        Collections.sort(a);
        int nhoK = a.get(K-1);
        int lonK = a.get(a.size()-K);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(nhoK, lonK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}
