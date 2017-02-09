import services.KataService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by franciscoraya on 9/2/17.
 */
public class Main {
    public static void main (String [] args) throws SQLException {
        try {
            createDatabase();
        }
        catch(Exception e) {}
        KataService service = new KataService();
        String name = service.getName("user2");
        String password = service.getPassword("user2");
        System.out.println(name);
        System.out.println(password);
    }


    public static void createDatabase()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");

            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "CREATE TABLE Users (" +
                    " NAME           TEXT    NOT NULL, " +
                    " PASSWORD           TEXT    NOT NULL, " +
                    " USERNAME            TEXT     NOT NULL) ";
            stmt.executeUpdate(sql);
            String datos = "INSERT INTO USERS (NAME, PASSWORD, USERNAME) VALUES('name user 2', 'pass user 2', 'user2')";
            stmt.executeUpdate(datos);
            stmt.close();
            c.close();
        } catch ( Exception e ) {

        }
        System.out.println("Table created successfully");
    }
}

