/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.CustomerSign;
import view.PharmaSign;
import view.mainapp.CusViewMed;
import view.mainapp.PhamViewMed;

/**
 *
 * @author debuayanri_sd2022
 */
public class AccountsDatabase {

    public ArrayList<Customer> customerDB = new ArrayList<>();
    public ArrayList<Pharmacist> pharmacistDB = new ArrayList<>();


    public AccountsDatabase() {
        getAllCustomer();
        getAllPharmacist();
    }

    //for getting all the customer in database
    public ArrayList<Customer> getAllCustomer() {
        try {

            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From Customer";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            while (rst.next()) {
                Customer cust = new Customer(rst.getString("name"), rst.getString("address"), rst.getString("username"), rst.getString("password"), rst.getInt("age"));
                cust.id = rst.getString("customer_id");
                customerDB.add(cust);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return customerDB;
    }
    //---------------------------------------------------------

    
    //pharmacist getAlltheCustomer and put in the table
    public void pharmacistRetrieveCust(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From customer";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            while (rst.next()) {
                model.addRow(new Object[]{rst.getString("customer_id"), rst.getString("name"), rst.getString("address"), rst.getString("username"), rst.getInt("age"), rst.getString("discounted")});
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    //--------------------------------------------------------- 
    

    
    //sending to mainapp
    public void CustMainApp(Customer c) {
        JOptionPane.showMessageDialog(null, "Successfully Loggged In!");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    String myDriver = "com.mysql.jdbc.Driver";

                    String myUrl = "jdbc:mysql://localhost/rica_java";
                    Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    // create a sql date object so we can use it in our INSERT statement
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                    final String queryCheck = "SELECT customer_id,username from customer WHERE username = ?";
                    final PreparedStatement ps = conn.prepareStatement(queryCheck);
                    ps.setString(1, c.getUsername());
                    final ResultSet resultSet = ps.executeQuery();

                    if (resultSet.next()) {
                        if (resultSet.getString("username").equals(c.getUsername())) {
                            CusViewMed cm = new CusViewMed();
                            cm.customerName.setText(c.getName());
                            cm.customerID.setText("ID: " + resultSet.getString("customer_id"));
                            cm.setVisible(true);

                        }
                    }

                    conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                }

            }
        });
    }
    //---------------------------------------------------------

    //for getting all the pharmacist in database
    public ArrayList<Pharmacist> getAllPharmacist() {
        try {

            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From Pharmacist";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            while (rst.next()) {
                Pharmacist ph = new Pharmacist(rst.getString("name"), rst.getString("address"), rst.getString("username"), rst.getString("password"));
                ph.id = rst.getString("pharmacist_id");
                pharmacistDB.add(ph);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return pharmacistDB;
    }

    //sending pharmacist to main app
    public void PharmMainApp(Pharmacist c) {
        JOptionPane.showMessageDialog(null, "Successfully Loggged In!");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    String myDriver = "com.mysql.jdbc.Driver";

                    String myUrl = "jdbc:mysql://localhost/rica_java";
                    Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    // create a sql date object so we can use it in our INSERT statement
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                    final String queryCheck = "SELECT pharmacist_id,username from pharmacist WHERE username = ?";
                    final PreparedStatement ps = conn.prepareStatement(queryCheck);
                    ps.setString(1, c.getUsername());
                    final ResultSet resultSet = ps.executeQuery();

                    if (resultSet.next()) {
                        if (resultSet.getString("username").equals(c.getUsername())) {
                            PhamViewMed m = new PhamViewMed();
                            m.pharmacistName.setText(c.getName());
                            m.pharmacistID.setText("ID: " + resultSet.getString("pharmacist_id"));
                            m.setVisible(true);

                        }
                    }

                    conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                }

            }
        });
    }
    //---------------------------------------------------------

    ///for customer registration
    public void CusRegister(Customer c, JFrame frame) {
        try {

            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            //checking if username exist
            final String queryCheck = "SELECT username from customer WHERE username = ?";
            final PreparedStatement ps = conn.prepareStatement(queryCheck);
            ps.setString(1, c.getUsername());
            final ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("username").equals(c.getUsername())) {
                    JOptionPane.showMessageDialog(null, "Username Already Taken!");
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new CustomerSign().setVisible(true);
                        }
                    });
                    frame.dispose();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            } else {
                Customer b = new Customer(c.getName(), c.getAddress(), c.getUsername(), c.getPassword(), c.getAge());
                //for saving to db
                // the mysql insert statement
                String query = " insert into customer(customer_id,name,address,username,password,age,discounted)"
                        + " values (?,?,?,?,?,?,?)";

                String id = "select count(*) from customer";
                PreparedStatement st = conn.prepareStatement(id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    b.customerIDno = rs.getInt("count(*)") + 1;
                }
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, b.getId());
                preparedStmt.setString(2, b.getName());
                preparedStmt.setString(3, b.getAddress());
                preparedStmt.setString(4, b.getUsername());
                preparedStmt.setString(5, b.getPassword());
                preparedStmt.setInt(6, b.getAge());
                if(b.getAge()>=60){
                    preparedStmt.setString(7, "yes");
                }else{
                     preparedStmt.setString(7, "no");
                }

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
                JOptionPane.showMessageDialog(null, "☻Successfully Registered☻!");
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    //---------------------------------------------------------

    public void PharmRegister(Pharmacist p, JFrame frame) {
        try {
            // create a mysql database connection

            //com.mysql.cj.jdbc.Driver
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

//checking if username exist
            final String queryCheck = "SELECT username from pharmacist WHERE username = ?";
            final PreparedStatement ps = conn.prepareStatement(queryCheck);
            ps.setString(1, p.getUsername());
            final ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("username").equals(p.getUsername())) {
                    JOptionPane.showMessageDialog(null, "Username Already Taken!");
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new PharmaSign().setVisible(true);
                        }
                    });
                    frame.dispose();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            } else {
                Pharmacist b = new Pharmacist(p.getName(), p.getAddress(), p.getUsername(), p.getPassword());
                //for saving to db
                // the mysql insert statement
                String query = " insert into pharmacist(pharmacist_id,name,address,username,password)"
                        + " values (?,?,?,?,?)";

                String id = "select count(*) from pharmacist";
                PreparedStatement st = conn.prepareStatement(id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    b.pharmacistID = rs.getInt("count(*)") + 1;
                }
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, b.getId());
                preparedStmt.setString(2, b.getName());
                preparedStmt.setString(3, b.getAddress());
                preparedStmt.setString(4, b.getUsername());
                preparedStmt.setString(5, b.getPassword());

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
                JOptionPane.showMessageDialog(null, "☻Successfully Registered☻!");
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    //---------------------------------------------------------

    
   
}
