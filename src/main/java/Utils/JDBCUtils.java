package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class JDBCUtils {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String DRIVER;
    static{
        try {
            Properties prop = new Properties();
            URL pathURL = JDBCUtils.class.getClassLoader().getResource("jdbc.properties");
            String path = Objects.requireNonNull(pathURL).getPath();
            prop.load(new FileReader(path));
            URL = prop.getProperty("url");
            USER = prop.getProperty("user");
            PASSWORD = prop.getProperty("password");
            DRIVER = prop.getProperty("driver");
            Class.forName(DRIVER);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void releaseSource(Statement stmt, Connection conn) {
        if(null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void releaseSource(ResultSet res, Statement stmt, Connection conn) {
        if(null != res) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        releaseSource(stmt,conn);
    }
}
