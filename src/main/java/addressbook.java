import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class addressbook {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/addressBook";
        String USER = "root";
        String PASS = "root";
        Connection conn;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = null;
                stmt= conn.createStatement();
            stmt.executeUpdate("insert into contact_table(first_name,last_name,address,city,state,zip,phone_number,email)values(\"sukanya\",\"naik\",\"srishti complex\",\"virar\",\"maharshtra\",401303,9822045799,\"sukanyanaik@gmail.com\"),(\"ganesh\",\"patil\",\"agarwal complex\",\"vasai\",\"delhi\",401313,9768145666,\"ganesh@gmail.com\"),(\"tanushree\",\"rai\",\"tanuja complex\",\"borivali\",\"hariyana\",401113,9822044449,\"rai@gmail.com\"),\n" +
                    "                                      (\"mahesh\",\"chavan\",\"gokul complex\",\"andheri\",\"kanrataka\",401311,9822066669,\"mahesh@gmail.com\"),(\"priya\",\"raut\",\"bhatia complex\",\"dadar\",\"tamilnadu\",401444,9822088899,\"priya@gmail.com\")");

            System.out.println("Created table in given database...");
            boolean val = stmt.execute("Select * from contact_table");
            System.out.println(val);
            if(val){
                ResultSet rs = stmt.getResultSet();
                while (rs.next()){
//                  retrieve by column name
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println(", Name: " + rs.getString("first_name"));
                    System.out.println(", lastName: " + rs.getString("last_name"));
                    System.out.println(", address: " + rs.getString("address"));
                    System.out.println(", city: " + rs.getString("city"));
                    System.out.println(", state: " + rs.getString("state"));
                    System.out.println(", zip: " + rs.getInt("zip"));
                    System.out.println(", phonenumber: " + rs.getLong("phone_number"));
                    System.out.println(", email: " + rs.getString("email"));
                    System.out.println();
                }
            }else {
                int count2 = stmt.getUpdateCount();
                System.out.println(count2);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
