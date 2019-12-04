/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import model.Customer;
import model.DatabaseRecords;

/**
 *
 * @author debuayanri_sd2022
 */
public class CustomerController {

    DatabaseRecords dbr;

    
    //getting all customers
    public ArrayList<Customer> getAllCustomer() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From Customer";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            while (rst.next()) {
                Customer cust = new Customer(rst.getString("name"), rst.getString("address"), rst.getString("username"), rst.getString("password"), rst.getInt("age"));
                cust.id = rst.getString("customer_id");
                dbr.customerDB.add(cust);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return dbr.customerDB;
    }
    
    
    //for login function check if naa sa db
    public boolean logIn(Customer c) {

        for (Customer customerList1 : dbr.customerDB) {
            if (customerList1.getUsername().equals(c.getUsername()) && customerList1.getPassword().equals(c.getPassword())) {
                c.setName(customerList1.getName());
                c.setAge(customerList1.getAge());
                c.setPassword(customerList1.getPassword());
                c.setAddress(customerList1.getAddress());
                c.setUsername(customerList1.getUsername());
                c.customerIDno = customerList1.customerIDno;

                return true;
            }
        }
        return false;
    }

    
    
    
}
