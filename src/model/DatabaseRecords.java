/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author debuayanri_sd2022
 */
public class DatabaseRecords {

    public ArrayList<Customer> customerDB = new ArrayList<>();

    public void getAllMedicine(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
// create a mysql database connection

            //com.mysql.cj.jdbc.Driver
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From Medicine";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            while (rst.next()) {
                model.addRow(new Object[]{rst.getString("drug_id"), rst.getString("drug_name"), rst.getString("generic_name"), rst.getString("brand_name"), rst.getInt("drug_stock"), rst.getDouble("drug_price"), rst.getString("expiration_date"), rst.getString("manufactured_date"), rst.getString("manufacturer"), rst.getString("category")});
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
