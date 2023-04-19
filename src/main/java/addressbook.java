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
            stmt.executeUpdate("CREATE TABLE contact_table(id int not null auto_increment primary key,first_name varchar(30) not null,\n" +
                    "                       last_name varchar(30) not null,\n" +
                    "                       address varchar(30),\n" +
                    "                       city varchar(30),\n" +
                    "                       state varchar(30),\n" +
                    "                        zip int,\n" +
                    "                        phone_number long,\n" +
                    "                        email varchar(40))");
            System.out.println("Created table in given database...");
            boolean val = stmt.execute("Select * from contact_table");
            System.out.println(val);
            if(val){
                ResultSet rs = stmt.getResultSet();
                while (rs.next()){
//                  retrieve by column name
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println(", Name: " + rs.getString("first_name"));
                    System.out.println(", Name: " + rs.getString("last_name"));
                    System.out.println(", Name: " + rs.getString("address"));
                    System.out.println(", Name: " + rs.getString("city"));
                    System.out.println(", Name: " + rs.getString("state"));
                    System.out.println(", Name: " + rs.getInt("zip"));
                    System.out.println(", Name: " + rs.getLong("phone_number"));
                    System.out.println(", Name: " + rs.getString("email"));
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
