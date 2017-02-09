package manager;

import java.util.HashMap;
import java.sql.*;
/**
 * Created by franciscoraya on 9/2/17.
 */
public class UserManager
{
    public static HashMap getUserByUsername(String username) throws SQLException {

        Connection c = null;
        PreparedStatement stmt = null;
        HashMap<String, String> result = new HashMap<String, String>();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.prepareStatement("SELECT * FROM Users where USERNAME=?;");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result.put("name", rs.getString("NAME"));
                result.put("password", rs.getString("PASSWORD"));

            }
            else throw new SQLException("No hay datos");
        } catch ( Exception e ) {
           throw new SQLException("Error al conectar: " + e.getMessage());
        }
        return result;

    }


}
