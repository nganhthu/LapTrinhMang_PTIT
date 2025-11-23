/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapobject;

/**
 *
 * @author Acer
 */

import java.util.*;
import vn.medianews.*;

public class QuanLyNhanVienY {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN662", qCode ="5cLoH68b";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY>a = (List<EmployeeY>) port.requestListEmployeeY(msv, qCode);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2){
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        port.submitListEmployeeY(msv, qCode, a);
    }
}
