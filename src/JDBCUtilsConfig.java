import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by hust on 2018/2/3.
 */
public class JDBCUtilsConfig {

    private static Connection connection;
    private static String driverclass;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            config();
            Class.forName(driverclass);
            connection = DriverManager.getConnection(url,username,password);

        } catch (Exception e) {
            System.out.print("数据库连接失败...");
        }

    }

    private static void config() throws Exception{
        InputStream in = JDBCUtilsConfig.class.getResourceAsStream("JDBCconfig.properties");
        Properties properties = new Properties();
        properties.load(in);
        driverclass = properties.getProperty("driverclass");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static Connection getConnection() {
        return connection;
    }
}
