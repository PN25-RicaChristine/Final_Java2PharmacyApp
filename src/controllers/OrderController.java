/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.OrderDatabase;

/**
 *
 * @author debuayanri_sd2022
 */
public class OrderController {
    
    OrderDatabase od = new OrderDatabase();
    
    public String addOrder(JLabel customerID, JTextField required_date, JLabel total_amount, JComboBox payment, JTextField comments){
       return od.createOrder(customerID, required_date, total_amount, payment, comments);
    }
    
    public void addDetails(String order_id,String drug_id, int quantity_ordered, double subtotal){
        od.createDetails(order_id, drug_id, quantity_ordered, subtotal);
    }
    
    public void getCustOrder(JTable table, JLabel customer_id){    
        od.retrieveCustomerOrder(table, customer_id);
    }
    
    public void getOrderDetails(JTable table, String order_id){
        od.retrieveOrderDetails(table, order_id);
    }
    
    public void cancelOrder(String id){
        od.deleteOrder(id);
    }
    
    public void getCustomerAllOrder(JTable table){
        od.retrieveCustomerAllOrder(table);
    }
}
 