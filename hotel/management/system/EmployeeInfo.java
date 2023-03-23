package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*; 
import java.awt.event.*;
public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeeInfo()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eight.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(550, 650, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(500, 0, 530, 550);
//        add(image);
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(400,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        
        JLabel l6 = new JLabel("Mobile No.");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        
        JLabel l7 = new JLabel("Aadhar No.");
        l7.setBounds(770,10,100,20);
        add(l7);
        
        
        JLabel l8 = new JLabel("Email");
        l8.setBounds(900,10,100,20);
        add(l8);
        
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args)
    {
        new EmployeeInfo();
    }
}
