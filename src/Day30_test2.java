import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hust on 2018/2/6.
 */
public class Day30_test2 {
    public static void main(String[] args) throws SQLException {
        //query1();
        //query2();
        //query3();
        query4();
        DbUtils.closeQuietly(con);
    }
    private static Connection con = JDBCUtilsConfig.getConnection();

    private static void query4() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT COUNT(*) FROM student";
        Object result = qr.query(con,sql,new ScalarHandler<Object>());
        System.out.println(result);
    }

    private static void query3() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM student";
        List<Object> result = qr.query(con,sql,new ColumnListHandler<Object>("sname"));
        for (Object o:result) {
            System.out.println(o);
        }
    }

    private static void query2() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM student";
        List<Day30_student> list = qr.query(con,sql,new BeanListHandler<Day30_student>(Day30_student.class));
        for (Day30_student student:list) {
            System.out.println(student);
        }
    }

    private static void query1() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM student";
        List<Object[]> list = qr.query(con,sql,new ArrayListHandler());
        for (Object[] objects:list){
            for (Object o: objects) {
                System.out.print(o + "\t");
            }
            System.out.println();
        }
    }
}
