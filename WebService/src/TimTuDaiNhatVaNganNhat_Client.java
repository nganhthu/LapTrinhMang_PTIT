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

public class TimTuDaiNhatVaNganNhat_Client {
    public static void main(String[] args) throws Exception {
        // a) Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN699";   // <-- điền mã sinh viên của bạn
        String qCode = "MYlcDgUp";           // mã câu hỏi trong đề

        // a) Kết nối đến CharacterService
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        // a) Gọi phương thức requestString để nhận chuỗi từ server
        String input = port.requestString(studentCode, qCode);
        System.out.println("Input string: " + input);

        if (input == null || input.trim().isEmpty()) {
            System.out.println("Chuỗi rỗng, không có dữ liệu để xử lý.");
            return;
        }

        // b) Tách chuỗi thành các từ theo khoảng trắng
        String[] words = input.trim().split("\\s+");

        // Khởi tạo ban đầu
        String longest = words[0];
        String shortest = words[0];

        // b) Duyệt tìm từ dài nhất và ngắn nhất
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
            if (w.length() < shortest.length()) {
                shortest = w;
            }
        }

        // c) Tạo chuỗi kết quả theo định dạng "[từ lớn nhất]; [từ nhỏ nhất]"
        String result = longest + "; " + shortest;
        System.out.println("Output: " + result);

        // d) Gửi kết quả về server
        port.submitCharacterString(studentCode, qCode, result);

        // e) Kết thúc chương trình
        System.out.println("Đã submit kết quả thành công!");
    }
}
