package java2novice;

import java.sql.*;

public class JDBCassignment {
    static final String DB_URL = "jdbc:mysql://localhost/sakila";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection con = null;
        Statement stmt = null;
        JDBCassignment j = new JDBCassignment();
        // get the driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
            System.out.println("Created DB Connection....");
            ResultSet rs = stmt.executeQuery("select title, description," +
                    " release_year, rental_duration from film");

            while(rs.next()){
                film f = new film(rs.getString("title"), rs.getString("description"),
                        rs.getInt("release_year"),rs.getInt("rental_duration")) ;
                System.out.println(f);

            }
            rs.close();
            con.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}















//    The Sakila film rental company wants to classify its customers based on how many films
//    they’ve rented.  They want the following classification:
//
//        PLATINUM: rented 40 or more movies
//        GOLD: between 30 and 39
//        SILVER: between 20 and 29
//        BRONZE: between 10 and 19.
//
//        Write a JDBC program that runs a query to identify which category each customer belongs to.
//
//        Use a Java print statement to print out each customer id, name, address, city, district and country in addition to their status (Gold, Platinum, etc).  Hint: you will need to use multiple JOINS between tables.
//
//        For example, the first rows of the output should be:
//
//        '505', 'ABNEY', 'RAFAEL', '48 Maracabo Place', 'Talavera', 'Central Luzon', 'Philippines', SILVER
//        '504', 'ADAM', 'NATHANIEL', '786 Matsue Way', 'Joliet', 'Illinois', 'United States', SILVER
//        '36', 'ADAMS', 'KATHLEEN', '334 Munger (Monghyr) Lane', 'Arak', 'Markazi', 'Iran', SILVER








