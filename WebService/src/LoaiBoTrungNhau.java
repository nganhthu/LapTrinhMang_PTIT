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

public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN699", qCode = "q7J48aG";

        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();

        List<Integer> a = port.getData(msv, qCode);
        System.out.println("Input:  " + a);

        // Loại bỏ trùng nhau, giữ thứ tự xuất hiện đầu tiên
        // LinkedHashSet đảm bảo: không trùng + bảo toàn thứ tự thêm vào
        Set<Integer> uniq = new LinkedHashSet<>(a);

        // Nếu submit yêu cầu List<Integer>, chuyển lại thành List
        List<Integer> ans = new ArrayList<>(uniq);

        System.out.println("Output: " + ans);

        // Gửi kết quả
        port.submitDataIntArray(msv, qCode, ans);
    }
}
