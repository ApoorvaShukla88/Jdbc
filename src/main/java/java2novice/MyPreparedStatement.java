package java2novice;

import java.sql.*;

public class MyPreparedStatement {


    static final String DB_URL = "jdbc:mysql://localhost/java2novice";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String a[]){
        Connection con = null;
        PreparedStatement prSt = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Created DB Connection....");
            String query = "insert into emp(empname,salary) values(?,?)";
            prSt = con.prepareStatement(query);
            prSt.setString(1, "John");
            prSt.setInt(2, 10000);
            //count will give you how many records got updated
            int count = prSt.executeUpdate();
            //Run the same query with different values
            prSt.setString(1, "Cric");
            prSt.setInt(2, 5000);
            count = prSt.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(prSt != null) prSt.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}
