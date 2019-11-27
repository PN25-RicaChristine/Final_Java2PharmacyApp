/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package pharmacysystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Botica extends JPanel {

    private JButton button1;
    private JButton button2;

    public Botica() {
        button1 = new JButton();
        this.setLayout(null);
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setText("button");
        button1.setLocation(50, 0);
        button1.setSize(100, 100);
        button1.setVisible(true);
        this.add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 button1.setSize(200, 200);
                button1.setText("Hello, I am Clicked!!");
            }

        });

    }

    public static void main(String[] args) {
        Botica botica = new Botica();
        JFrame fram = new JFrame();

        fram.setVisible(true);
        fram.setBounds(10, 10, 500, 500);
        fram.add(botica);
        fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
