/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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
}
