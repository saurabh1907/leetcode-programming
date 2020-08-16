package main.others;

import java.sql.*;
public class MYSQLConnection{
    
    public static void main1(String[] args)throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/saurabh?"+"user=root&password=admin");
        Statement stmt=con.createStatement();
        String query="SELECT * FROM branch";
        ResultSet rs=stmt.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
        while(rs.next()){
            System.out.println(rs.getString(1)+"   "+rs.getString(2)+"     "+rs.getInt(3));
        }System.out.println("----------------------------------------------------------------------------");
        System.out.println(rsmd.getColumnName(1));
        rs.close();
        stmt.close();
        con.close();
    }
    
}
