import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class addressbook {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/addressbook";
        String USER = "root";
        String PASS = "root";
        Connection con;
        try {
            System.out.println("Connecting to database: "+DB_URL);
            try {
                con = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = null;
                stmt= con.createStatement();
            int count = stmt.executeUpdate("insert into addressBook(first_name,last_name,address_book_name,type,address,city,state,zip,phone_number,email) values(\"vikas\",\"patil\",\"bcd\",\"Friend\",\"pune\",\"pune\",\"Maharashtra\",423134,234323,\"hajare11@gmail.com\")");
                System.out.println(count);
                boolean val =stmt.execute("select * from addressBook");
                if(val) {
                    ResultSet rs = stmt.getResultSet();
                    while (rs.next()) {
                        System.out.print(", first_name: " + rs.   getString("first_name"));
                        System.out.print(", last_name: " + rs.   getString("last_name"));
                        System.out.print(", address_book_name: " + rs.getString("address_book_name"));
                        System.out.print(", type: " + rs.getString("type"));
                        System.out.print(", address: " + rs.getString("address"));
                        System.out.print(", address: " + rs.   getString("address"));
                        System.out.print(", city: " + rs.   getString("city"));
                        System.out.print(", state: " + rs.getString("state"));
                        System.out.print(", zip: " + rs.getInt("zip"));
                        System.out.print(", phone_number: " + rs.getString("phone_number"));
                        System.out.print(", email: " + rs.getString("email"));

                        System.out.println();
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Connection is successful!!!! "+con);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
