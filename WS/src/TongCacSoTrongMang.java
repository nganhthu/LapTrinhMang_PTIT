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

public class TongCacSoTrongMang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode = "agkfag";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int tong = 0;
        for(int x : a){
            tong += x;
        }
        port.submitDataInt(msv, qCode, tong);
    }
}
