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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author debuayanri_sd2022
 */
public class OrderDatabase {

    public OrderDatabase() {

    }

    //add orders
    public String createOrder(JLabel customerID, JTextField required_date, JLabel total_amount, JComboBox payment, JTextField comments) {
        String orderID = "";
        try {
            // create a mysql database connection

            //com.mysql.cj.jdbc.Driver
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            //for saving to db
            // the mysql insert statement
            String query = " insert into orders(order_id,customer_id, date_time,required_date,total_amount,discounted,payment,comment)"
                    + " values (?,?,?,?,?,?,?,?)";
            String id = "select count(*) from orders";
            PreparedStatement st = conn.prepareStatement(id);
            ResultSet rs = st.executeQuery();
            String order_id = "ORID-";

            final String queryCheck = "SELECT discounted from customer WHERE customer_id = ?";
            final PreparedStatement ps = conn.prepareStatement(queryCheck);
            ps.setString(1, customerID.getText().substring(4));
            final ResultSet resultSet = ps.executeQuery();
            String stat = "";

            while (rs.next()) {
                order_id += rs.getString("count(*)");
            }

            if (resultSet.next()) {
                stat += resultSet.getString("discounted");

            }

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
            String strDate = dateFormat.format(date);
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, order_id);
            preparedStmt.setString(2, customerID.getText().substring(4));
            preparedStmt.setString(3, strDate);
            preparedStmt.setString(4, required_date.getText());
            preparedStmt.setDouble(5, Double.parseDouble(total_amount.getText()));
            preparedStmt.setString(6, stat);
            preparedStmt.setString(7, payment.getSelectedItem().toString());
            preparedStmt.setString(8, comments.getText());

            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
            orderID = order_id;
//            JOptionPane.showMessageDialog(null, "☻Successfully Placed Orders☻!");

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return orderID;

    }

    public void createDetails(String order_id,String drug_id, int quantity_ordered, double subtotal) {
        try {

            // create a mysql database connection
            //com.mysql.cj.jdbc.Driver
            String myDriver = "com.mysql.jdbc.Driver";

            String myUrl = "jdbc:mysql://localhost/rica_java";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String details = " insert into order_details(order_id,drug_id, quantity_ordered,subtotal_amount)"
                    + " values (?,?,?,?)";
            PreparedStatement mt = conn.prepareStatement(details);
            mt.setString(1, order_id);
            mt.setString(2, drug_id);
            mt.setInt(3, quantity_ordered);
            mt.setDouble(4, subtotal);

            mt.execute();

            conn.close();
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!");

        }
    }
}
