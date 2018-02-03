import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2018/1/18.
 * JDBCcao操作数据库步骤
 1.	注册驱动.
        告知JVM使用的是哪一个数据库的驱动
 2.	获得连接.
        使用JDBC中的类，完成对MYSQL数据库的连接
 3.	获得语句执行平台
        通过连接对象获取对SQL语句的执行者对象
 4.	执行sql语句
        使用执行者对象，向数据库执行SQL语句
        获取到数据库的执行后的结果
 5.	处理结果
 6.	释放资源
        调用很多 close();

 */
public class Day29_JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        //1.注册驱动，用反射技术，将驱动类加入内容
        //use java.sql.DriverManager类静态方法registerDriver(Driver driver)
        //Driver  是接口,MYSQL驱动程序中的实现类
        //DriverManager.registerDriver(new Driver());
        //看驱动类源代码，其中注册了2次驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        //2.获得数据库连接DriverManager类中的静态方法
        //static Connection getConnection(String url,String user,String password)
        //返回值是Connection接口的实现类，在mysql驱动程序
        //url: 数据库地址 jdbc:mysql://连接的主机的IP:端口号//数据库的名字
        String url = "jdbc:mysql://localhost:3306/day29_jdbc";
        String username = "root";
        String password = "043043";
        Connection con = DriverManager.getConnection(url,username,password);

        //3. 获取语句执行平台，通过数据库连接对象，获取到SQL语句的执行者对象
        // con对象调用方法 Statement createStatement() 获取Statement对象，讲SQL语句发送到数据库
        // 返回值是Statement接口的实现类对象，在mysql驱动中
        Statement stat = con.createStatement();

        //4.执行sql语句
        //通过执行者对象调用方法执行SQL语句，获取结果
        //int executeUpdate(String sql) 执行数据库中的SQL语句（insert,delete,update）
        //返回值int是操作成功数的行数
        int row = stat.executeUpdate("INSERT INTO sort(sname,sprice,sdesc) VALUES ('汽车用品',500000,'疯狂涨价')");
        System.out.print(row);


        //6. 释放资源 一堆close();
        stat.close();
        con.close();

    }
}
