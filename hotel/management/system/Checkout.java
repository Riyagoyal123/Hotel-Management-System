package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    Checkout()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        
        JLabel lblcheckin = new JLabel("CheckIn Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,140,30);
        add(lblcheckintime);
        
        
        JLabel lblcheckout = new JLabel("CheckOut Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,140,30);
        add(lblcheckouttime);
        
        
        checkout = new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("contact"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkinTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkout)
        {
            String query1 = "delete from customer where contact = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Yes' where room = '"+lblroomnumber.getText()+"'"; 
            
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Checkout Done");
                
                new Reception();
                setVisible(false);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args)
    {
        new Checkout();
    }
}
