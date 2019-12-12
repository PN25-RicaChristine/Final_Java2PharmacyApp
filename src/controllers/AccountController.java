/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import javax.swing.JTable;
import model.Customer;
import model.AccountsDatabase;
import model.Pharmacist;

/**
 *
 * @author debuayanri_sd2022
 */
public class AccountController {

    AccountsDatabase adb = new AccountsDatabase();

    //for login function check if naa sa db
    public boolean logIn(Customer c) {

        for (Customer customerList1 : adb.customerDB) {
            if (customerList1.getUsername().equals(c.getUsername()) && customerList1.getPassword().equals(c.getPassword())) {
                c.setName(customerList1.getName());
                c.setAge(customerList1.getAge());
                c.setPassword(customerList1.getPassword());
                c.setAddress(customerList1.getAddress());
                c.setUsername(customerList1.getUsername());
                c.customerIDno = customerList1.customerIDno;
                adb.CustMainApp(c);
                return true;

            }
        }

        return false;
    }
    
    
    
  
    
    //for login function

    public boolean logIn(Pharmacist p) {
        for (Pharmacist pharmacistList1 : adb.pharmacistDB) {
            if (pharmacistList1.getUsername().equals(p.getUsername()) && pharmacistList1.getPassword().equals(p.getPassword())) {
                p.setName(pharmacistList1.getName());
                p.setPassword(pharmacistList1.getPassword());
                p.setAddress(pharmacistList1.getAddress());
                p.setUsername(pharmacistList1.getUsername());
                p.pharmacistID = pharmacistList1.pharmacistID;
                adb.PharmMainApp(p);
                return true;
            }
        }
        return false;
    }

    
    public void authentication(Customer c, JFrame frame){
        adb.CusRegister(c,frame);
    }
    
    public void authentication(Pharmacist p, JFrame frame){
        adb.PharmRegister(p,frame);
    }
    
    public void viewCustomer(JTable table){
        adb.pharmacistRetrieveCust(table);
    }
}
