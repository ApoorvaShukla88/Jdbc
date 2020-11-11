package java2novice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MyResultSetMetadata {


    static final String DB_URL = "jdbc:mysql://localhost/java2novice";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String a[]){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Created DB Connection....");
            st = con.createStatement();
            rs = st.executeQuery("select * from emp");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for(int i=0;i<columnCount;i++){
                System.out.println(rsmd.getColumnName(i));
                System.out.println(rsmd.getColumnType(i));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
    }
}
