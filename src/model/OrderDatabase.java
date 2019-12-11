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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.mainapp.PhamControlMed;

/**
 *
 * @author debuayanri_sd2022
 */
public class OrderDatabase {
    public OrderDatabase(){
        
    }
     //add orders
    public void addOrder(Medicine m, String drug_id, JFrame frame) {
        try {
            // create a mysql database connection

            //com.mysql.cj.jdbc.Driver
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");


            final String queryCheck = "SELECT drug_id from medicine WHERE drug_id = ?";
            final PreparedStatement ps = conn.prepareStatement(queryCheck);
            ps.setString(1, drug_id);
            final ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("drug_id").equals(drug_id)) {
                    JOptionPane.showMessageDialog(null, "DRUG ID should be UNIQUE!");
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new PhamControlMed().setVisible(true);
                        }
                    });
                    frame.dispose();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            } else {

                //for saving to db
                // the mysql insert statement
                String query = " insert into medicine(drug_id,drug_name, generic_name,brand_name,drug_stock,drug_price,expiration_date,manufactured_date,manufacturer,category)"
                        + " values (?,?,?,?,?,?,?,?,?,?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, m.getDrugID());
                preparedStmt.setString(2, m.getDrugName());
                preparedStmt.setString(3, m.getGenericName());
                preparedStmt.setString(4, m.getBrandName());
                preparedStmt.setInt(5, m.getDrugAvailability());
                preparedStmt.setDouble(6, m.getDrugPrice());
                preparedStmt.setString(7, m.getExpirationDate());
                preparedStmt.setString(8, m.getManufacturedDate());
                preparedStmt.setString(9, m.getManufacturer());
                preparedStmt.setString(10, m.getCategory());

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
                JOptionPane.showMessageDialog(null, "☻Successfully Added☻!");
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
