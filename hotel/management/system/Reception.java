package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Reception extends JFrame implements ActionListener {
    JButton newCustomer, roomInfo, employeeInfo, customerInfo, updateAmount, checkout, logout;
    Reception()
    {
        setLayout(null);
        
        newCustomer = new JButton("CHECK IN");
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setFont(new Font("Tahoma",Font.PLAIN,17));
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
        roomInfo = new JButton("ROOM INFO");
        roomInfo.setBackground(Color.BLACK);
        roomInfo.setForeground(Color.WHITE);
        roomInfo.setBounds(10,80,200,30);
        roomInfo.setFont(new Font("Tahoma",Font.PLAIN,17));
        roomInfo.addActionListener(this);
        add(roomInfo);
        
        
        employeeInfo = new JButton("EMPLOYEE INFO");
        employeeInfo.setBackground(Color.BLACK);
        employeeInfo.setForeground(Color.WHITE);
        employeeInfo.setBounds(10,130,200,30);
        employeeInfo.setFont(new Font("Tahoma",Font.PLAIN,17));
        employeeInfo.addActionListener(this);
        add(employeeInfo);
        
        
        customerInfo = new JButton("CUSTOMER INFO");
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.setBounds(10,180,200,30);
        customerInfo.setFont(new Font("Tahoma",Font.PLAIN,17));
        customerInfo.addActionListener(this);
        add(customerInfo);
        
        
        updateAmount = new JButton("PENDING AMOUNT");
        updateAmount.setBackground(Color.BLACK);
        updateAmount.setForeground(Color.WHITE);
        updateAmount.setBounds(10,230,200,30);
        updateAmount.setFont(new Font("Tahoma",Font.PLAIN,17));
        updateAmount.addActionListener(this);
        add(updateAmount);
        
        
        checkout = new JButton("CHECKOUT");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(10,280,200,30);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkout.addActionListener(this);
        add(checkout);
        
        
        logout = new JButton("LOGOUT");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(10,330,200,30);
        logout.setFont(new Font("Tahoma",Font.PLAIN,17));
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(230,30,450,330);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(570,200,700,450);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == newCustomer)
        {
            setVisible(false);
            new Checkin();
        }
        else if(ae.getSource() == roomInfo)
        {
             setVisible(false);
             new RoomInfo();
        }
        else if(ae.getSource() == employeeInfo)
        {
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == customerInfo)
        {
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == updateAmount)
        {
            setVisible(false);
            new UpdateDeposit();
        }
        else if(ae.getSource() == checkout)
        {
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource() == logout)
        {
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new Reception();
    }
}
