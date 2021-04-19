
package blood.bank.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author shahzaib saeed
 */
public class DBConnector {
    public static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");
        return con;
    }
}
