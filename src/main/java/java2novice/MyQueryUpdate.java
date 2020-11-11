package java2novice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyQueryUpdate {


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
          //  stmt = con.createStatement();
            String query = "update emp set salary=2000 where empname='charu'";
            //count will give you how many records got updated
            int count = stmt.executeUpdate(query);
            System.out.println("Updated queries: "+count);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}
