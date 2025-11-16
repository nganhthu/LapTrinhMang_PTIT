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
        // a) Thông tin cần thiết
        String studentCode = "B21DCCN699";   // Mã sinh viên của bạn
        String qCode = "q7J48aG5";           // Mã câu hỏi

        // a) Kết nối đến dịch vụ web
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();

        // a) Gọi phương thức getData để nhận danh sách số nguyên
        List<Integer> data = port.getData(studentCode, qCode);
        System.out.println("Input:  " + data);

        if (data == null) data = Collections.emptyList();

        // b) Loại bỏ phần tử trùng, giữ lại thứ tự đầu tiên
        // LinkedHashSet đảm bảo: không trùng + bảo toàn thứ tự
        Set<Integer> uniqueSet = new LinkedHashSet<>(data);

        // Chuyển về List<Integer> để gửi lại
        List<Integer> result = new ArrayList<>(uniqueSet);

        System.out.println("Output (Unique): " + result);

        // c) Gửi mảng kết quả trở lại server
        port.submitDataIntArray(studentCode, qCode, result);

        // d) Kết thúc chương trình
        System.out.println("Đã submit kết quả thành công.");
    }
}

