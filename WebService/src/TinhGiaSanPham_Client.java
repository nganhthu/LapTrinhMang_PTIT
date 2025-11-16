/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import vn.medianews.*;

public class TinhGiaSanPham_Client {
    public static void main(String[] args) throws Exception {
        // a) Thông tin sinh viên và mã câu hỏi
        String studentCode = "B21DCCN699";   // <-- điền mã sinh viên của bạn
        String qCode = "t6N2kfKd";           // mã câu hỏi trong đề

        // a) Kết nối đến dịch vụ web ObjectService
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        // a) Gọi phương thức requestProductY để nhận đối tượng ProductY
        ProductY product = port.requestProductY(studentCode, qCode);

        // In thông tin gốc
        System.out.println("Nhận từ server:");
        System.out.println("Price: " + product.getPrice());
        System.out.println("TaxRate: " + product.getTaxRate());
        System.out.println("Discount: " + product.getDiscount());

        // b) Tính finalPrice theo công thức:
        // finalPrice = price * (1 + taxRate/100) * (1 - discount/100)
        float price = product.getPrice();
        float taxRate = product.getTaxRate();
        float discount = product.getDiscount();

        float finalPrice = price * (1 + taxRate / 100f) * (1 - discount / 100f);

        // b) Cập nhật lại thuộc tính finalPrice
        product.setFinalPrice(finalPrice);

        System.out.println("Final price (đã tính): " + finalPrice);

        // c) Gửi đối tượng đã cập nhật lại server
        port.submitProductY(studentCode, qCode, product);

        // d) Kết thúc chương trình
        System.out.println("Đã submit ProductY thành công!");
    }
}

