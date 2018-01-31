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
}
