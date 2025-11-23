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

public class QuanLySinhVien {
    public static void main(String[] args) throws Exception{
        String msv = "B18DCCN335", qCode = "u7ue8HZl";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student>a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x : a){
            System.out.println(x);
        }
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x : a){
            if(x.getScore() > 8.0){
                ans.add(x);
            }else if (x.getScore() < 5.0) {
                ans.add(x);
            }
        }
        System.out.println(ans);
        port.submitListStudent(msv, qCode, ans);
    }
}
