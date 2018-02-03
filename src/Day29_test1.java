import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by hust on 2018/2/3.
 */
public class Day29_test1 {

    private static Connection con;
    private static String unanme;
    private static String upass;
    private static boolean findifhave() throws Exception {
        String selectSQL = "SELECT * FROM userinfo WHERE username=? AND PASSWORD=?";
        PreparedStatement selectSta = con.prepareStatement(selectSQL);
        System.out.println("Input username:");
        Scanner scanner = new Scanner(System.in);
        unanme = scanner.nextLine();
        System.out.println("Input password:");
        upass = scanner.nextLine();
        selectSta.setString(1,unanme);
        selectSta.setString(2,upass);
        ResultSet rs = selectSta.executeQuery();
        if (rs.next()) {
            selectSta.close();
            return true;
        } else {
            selectSta.close();
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day29_jdbc";
        String username = "root";
        String password = "043043";
        con = DriverManager.getConnection(url,username,password);
        if (findifhave()) {
            System.out.println("Already exist!");
        }else {
            insert();
        }
        con.close();

    }

    private static void insert() throws Exception{
        String insertSQL = "INSERT INTO userinfo(username,PASSWORD) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(insertSQL);
        ps.setString(1,unanme);
        ps.setString(2,upass);
        int line = ps.executeUpdate();
        System.out.println(line + " write complete!");
        ps.close();
    }

}
