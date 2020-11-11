package java2novice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyResultSetEx {

    static final String DB_URL = "jdbc:mysql://localhost/java2novice";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String a[]){
        Connection con = null;
        Statement stmt = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
            System.out.println("Created DB Connection....");
            ResultSet rs = stmt.executeQuery("select EMPNAME, SALARY from EMP");
            while(rs.next()){
                System.out.println(rs.getString("empname"));
                System.out.println(rs.getInt("salary"));
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
