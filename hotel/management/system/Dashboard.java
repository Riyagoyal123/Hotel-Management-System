package hotel.management.system;

//import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener {
    Dashboard()
    {
        setBounds(-5,0,2000,1030);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(2000, 1030, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-5,0,2000,1030);
        add(image);
        
        JLabel text = new JLabel("JW MARRIOTT WELCOMES YOU");
        text.setBounds(600,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 2000, 30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        admin.add(addroom);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOM"))
        {
            new AddRoom();
        }
         else if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
    }
    public static void main(String[] args)
    {
        new Dashboard();
    }
}
