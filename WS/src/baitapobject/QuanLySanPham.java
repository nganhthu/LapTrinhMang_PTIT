/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitapobject;

/**
 *
 * @author Acer
 */
import vn.medianews.*;
import java.util.*;

public class QuanLySanPham {
    public static void main(String[] args) throws Exception{
        String msv = "B21dccn699", qCode = "vasnlghl";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY a = (ProductY) port.requestProductY(msv, qCode);
        float price = a.getPrice();
        float taxRate = a.getTaxRate();
        float discount = a.getDiscount();
        float finalPrice = (float) (price * (1 + taxRate/100)*(1-discount/100));
        a.setFinalPrice(finalPrice);
        port.submitProductY(msv, qCode, a);
}
}
