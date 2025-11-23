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

public class QuanLySinhVienY {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode ="sgliagja";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY>a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        Map<String, Float>diemmax = new HashMap<>();
        for(StudentY x : a){
            String mon = x.getSubject();
            Float diem = x.getScore();
            if(!diemmax.containsKey(mon) || diem > diemmax.get(mon)){
                diemmax.put(mon, diem);
            }
        }
        
        List<Float>diemdl = new ArrayList<>(diemmax.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemdl.contains(x.getScore())){
                ans.add(x);
            }
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}
