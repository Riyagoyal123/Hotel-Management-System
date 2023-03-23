package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddRoom extends JFrame implements ActionListener{
    
    JTextField tfroom,tfprice;
    JRadioButton rbyes,rbno,rbclean,rbdirty;
    JComboBox cblabel;
    JButton add,cancel;
    
    AddRoom()
    {
        setLayout(null);
        
        JLabel lblroom = new JLabel("ROOM NO.");
        lblroom.setBounds(60, 30, 120, 30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroom);
        tfroom = new JTextField();
        tfroom.setBounds(200,30,150,30);
        add(tfroom);
        
        
        JLabel lblavailability = new JLabel("AVAILABLE");
        lblavailability.setBounds(60, 80, 120, 30);
        lblavailability.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailability);
        rbyes = new JRadioButton("Yes");
        rbyes.setBounds(200,80,70,30);
        rbyes.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbyes.setBackground(Color.WHITE);
        add(rbyes);
        rbno = new JRadioButton("No");
        rbno.setBounds(280,80,70,30);
        rbno.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbno.setBackground(Color.WHITE);
        add(rbno);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rbyes);
        bg1.add(rbno);
        
        
        JLabel lblcleaning = new JLabel("CLEAN STATUS");
        lblcleaning.setBounds(60, 130, 120, 30);
        lblcleaning.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcleaning);
        rbclean = new JRadioButton("Clean");
        rbclean.setBounds(200,130,70,30);
        rbclean.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbclean.setBackground(Color.WHITE);
        add(rbclean);
        rbdirty = new JRadioButton("Dirty");
        rbdirty.setBounds(280,130,70,30);
        rbdirty.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbdirty.setBackground(Color.WHITE);
        add(rbdirty);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rbclean);
        bg2.add(rbdirty);
        
        
        JLabel lblprice = new JLabel("PRICE");
        lblprice.setBounds(60, 180, 120, 30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblprice);
        tfprice = new JTextField();
        tfprice.setBounds(200,180,150,30);
        add(tfprice);
        
        
        JLabel lblbed = new JLabel("BED TYPE");
        lblbed.setBounds(60, 230, 120, 30);
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblbed);
        String str[] = {"Single","Double","Triple","Couple","Suite"};
        cblabel = new JComboBox(str);
        cblabel.setBounds(200,230,150,30);
        cblabel.setBackground(Color.WHITE);
        add(cblabel);
        
        
        add = new JButton("ADD ROOM");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(10,280,150,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,280,150,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,30,400,300);
        add(image);
        getContentPane().setBackground(Color.WHITE);
        setBounds(500,250,850,400);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
     {
        if(ae.getSource() == add){
        String room = tfroom.getText();
        String price = tfprice.getText();
        
        
        String availability = null;
        String cleaning = null;
        
        if(room.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Room shouldnot be empty");
            return;
        }
        if(rbyes.isSelected())
        {
            availability = "Yes";
        }
        else if(rbno.isSelected())
        {
            availability = "No";
        }     
         if(rbclean.isSelected())
        {
            cleaning = "Clean";
        }
        else if(rbdirty.isSelected())
        {
            cleaning = "Dirty";
        }   
        String bed = (String)cblabel.getSelectedItem();
        try{
            Conn conn = new Conn();
            String query = "insert into room values('"+room+"','"+availability+"','"+cleaning+"','"+price+"','"+bed+"')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Room added successfully");
            setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }else{
            setVisible(false);
        }
     }
    public static void main(String[] args)
    {
        new AddRoom();
    }
}
