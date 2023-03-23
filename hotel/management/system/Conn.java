package hotel.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms?characterEncoding=latin1", "root", "root");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println();
        }
    }

//    class s {
//
//        public s() {
//        }
//    }
}
