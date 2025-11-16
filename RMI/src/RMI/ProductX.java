/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Acer
 */
package RMI;
import java.io.Serializable;
public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107;
    private String id, code, discountCode;
    private int discount;
    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "ProductX [id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + "]";
    }
}

