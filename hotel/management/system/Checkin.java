package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Checkin extends JFrame implements ActionListener,ItemListener{
    
    JComboBox comboid; 
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime, tftotal;
    JButton add,back,check;
    Checkin()
    {
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel ("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Railway",Font.PLAIN,20));
        add(text);
        
        
        JLabel lbid = new JLabel ("ID");
        lbid.setBounds(35,80,100,20);
        lbid.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbid);
        String options[]={"Aadhar Card", "Passport", "Driving License", "Voter-id Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        
        JLabel lbnumber = new JLabel ("CONTACT");
        lbnumber.setBounds(35,120,100,20);
        lbnumber.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbnumber);
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        
        JLabel lbname = new JLabel ("NAME");
        lbname.setBounds(35,160,100,20);
        lbname.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Railway",Font.PLAIN,20));
        add(lblgender);
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,200,80,25);
        rbmale.setFont(new Font("Railway",Font.PLAIN,20));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,200,100,25);
        rbfemale.setFont(new Font("Railway",Font.PLAIN,20));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lbcountry = new JLabel ("COUNTRY");
        lbcountry.setBounds(35,240,100,20);
        lbcountry.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbcountry);
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        
        JLabel lbroomnumber = new JLabel ("ROOM NO.");
        lbroomnumber.setBounds(35,280,110,20);
        lbroomnumber.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbroomnumber);
        croom = new Choice();
        croom.addItemListener(this);
//        croom.addItemListener();
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability = 'yes' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("room"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        
        JLabel lbtime = new JLabel ("CHECKIN TIME");
        lbtime.setBounds(35,320,180,20);
        lbtime.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbtime);
        Date date = new Date();
        checkintime = new JLabel ("" + date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Railway",Font.PLAIN,15));
        add(checkintime);
        
        
        JLabel lbtotal = new JLabel ("TOTAL AMOUNT");
        lbtotal.setBounds(35,360,180,20);
        lbtotal.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbtotal);
        tftotal = new JLabel();
        tftotal.setBounds(200,360,150,25);
        add(tftotal);
        
        
        JLabel lbdeposit = new JLabel ("DEPOSIT");
        lbdeposit.setBounds(35,400,100,20);
        lbdeposit.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbdeposit);
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,400,150,25);
        add(tfdeposit);
        
        
        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,450,120,30);
        add.addActionListener(this);
        add(add);
        
        
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,450,120,30);
        back.addActionListener(this);
        add(back);
        
        
//        check = new JButton("CHECK PRICE");
//        check.setBackground(Color.BLACK);
//        check.setForeground(Color.WHITE);
//        check.setBounds(350,450,120,30);
//        check.addActionListener(this);
//        add(check);
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from room");
//            while (rs.next()) {
//                croom.add(rs.getString("room"));
//                //lblroomnumber.setText(rs.getString("room"));
//                tftotal.setText(rs.getString("price"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rbmale.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try{
                String query1 = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"')";
                String query2 = "update room set availability = 'No' where room = '"+room+"'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer added successfully");
                
                setVisible(false);
                new Reception();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource() == check)
        {
            
            }
        
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args)
    {
        new Checkin();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    if(e.getSource()==croom)
    {
        croom.getSelectedItem();
        String room = croom.getSelectedItem();
            String query = "select * from room where room = '" + room + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                   
                    tftotal.setText(rs.getString("price"));
                }
                }catch (Exception e1) {
                e1.printStackTrace();
            } 
    }
    }
}
