/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author Acer
 */

import java.io.Serializable;
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    private String id, customerCode, orderDate, shippingType, orderCode;
    public Order() {}
    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public String getShippingType() {
        return shippingType;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingType=" + shippingType + ", orderCode=" + orderCode + '}';
    }
}

