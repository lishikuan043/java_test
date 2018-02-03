import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by hust on 2018/2/3.
 * JDBC技术，查询数据表，获取结果集
 */
public class Day29_JDBCDemo1 {
    public static void main(String[] args) throws Exception  {
        //1.注册驱动，用反射技术，将驱动类加入内容
       // Connection con = JDBCUtilsConfig.getConnection();
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接
        String url = "jdbc:mysql://localhost:3306/day29_jdbc";
        String username = "root";
        String password = "043043";
        Connection con = DriverManager.getConnection(url,username,password);
        //3. 获取语句执行平台，通过数据库连接对象，获取到SQL语句的执行者对象
        Statement stat  = con.createStatement();
        //拼写一个SQL查询语句
        String sql = "SELECT * FROM sort";
        //4.获取结果集ResultSet executeQuery(String sql) 执行查询
        ResultSet rs = stat.executeQuery(sql);
        //5.处理结果集
        //ResultSet接口方法Boolean next() 返回true则有结果集
        while (rs.next()) {
            //获取每列数据，建议用列名
            System.out.println(rs.getInt("sid") + "  " + rs.getString("sname")
                    + "  " + rs.getDouble("sprice")+ "  " + rs.getString("sdesc"));
        }


        rs.close();
        stat.close();
        con.close();


    }

}
