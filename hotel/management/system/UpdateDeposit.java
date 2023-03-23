package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class UpdateDeposit extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfamount, tfcheckin, tfpending;
    JButton check, back, update;

    UpdateDeposit() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Pending Amount");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(50, 20, 250, 30);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("contact"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30, 120, 100, 30);
        add(lblroom);
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 35);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 30);
        add(lblname);
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 35);
        add(tfname);

        JLabel lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setBounds(30, 200, 100, 30);
        add(lblcheckin);
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 35);
        add(tfcheckin);

        JLabel lblamount = new JLabel("Amount Paid");
        lblamount.setBounds(30, 240, 100, 30);
        add(lblamount);
        tfamount = new JTextField();
        tfamount.setBounds(200, 240, 150, 35);
        add(tfamount);

        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30, 280, 100, 30);
        add(lblpending);
        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 35);
        add(tfpending);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where contact = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkinTime"));
                    tfamount.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfamount.getText());
                    tfpending.setText("" + amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfamount.getText();

            try {
                 Conn c = new Conn();
                 c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkinTime = '"+checkin+"', deposit = '"+deposit+"'");
            
                 JOptionPane.showMessageDialog(null,"Data updated successfully");
                 
                 setVisible(false);
                 new Reception();
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
                  setVisible(false);
                  new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateDeposit();
    }
}
