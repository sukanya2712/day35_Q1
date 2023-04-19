import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class addressbook {
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://localhost:3306/addressbook";
        String USER = "root";
        String PASS = "root";
        Connection conn;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement stmt = conn.prepareStatement("update addressbook set last_name=? where first_name =?");
                stmt.setString(1,"jagupriya");
                stmt.setString(2,"jagu");
            int count = stmt.executeUpdate();
            System.out.println(count + " rows updated");
                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery("select * from addressbook");
                    while (rs.next()) {
                        System.out.print(" first_name: " + rs.getString("first_name"));
                        System.out.print(", last_name: " + rs.getString("last_name"));
                        System.out.print(", address_book_name: " + rs.getString("address_book_name"));
                        System.out.print(", type: " + rs.getString("type"));
                        System.out.print(", address: " + rs.getString("address"));
                        System.out.print(", address: " + rs.getString("address"));
                        System.out.print(", city: " + rs.   getString("city"));
                        System.out.print(", state: " + rs.getString("state"));
                        System.out.print(", zip: " + rs.getInt("zip"));
                        System.out.print(", phone_number: " + rs.getString("phone_number"));
                        System.out.print(", email: " + rs.getString("email"));
                        System.out.println();
                    }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Connection is successful!!!! "+conn);
        }
    }
