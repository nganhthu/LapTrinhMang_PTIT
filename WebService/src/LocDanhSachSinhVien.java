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

public class LocDanhSachSinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN699", qCode = "YGYCPEJB";

        // Tạo client
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        // a) Lấy danh sách Student
        List<Student> input = port.requestListStudent(msv, qCode);
        if (input == null) input = Collections.emptyList();

        // b) Lọc nhóm A (>=8.0) và D (<5.0), giữ nguyên thứ tự ban đầu
        List<Student> result = new ArrayList<>();
        for (Student s : input) {
            float score = s.getScore();
            if (score >= 8.0f || score < 5.0f) {
                result.add(s);
            }
        }

        // c) Gửi danh sách đã lọc
        port.submitListStudent(msv, qCode, result);

        // In kiểm tra
        System.out.println("Input  : " + input.size() + " SV");
        System.out.println("Output : " + result.size() + " SV (A & D)");
        for (Student s : result) {
            System.out.println(s.getName() + " - " + s.getScore());
        }
    }
}
