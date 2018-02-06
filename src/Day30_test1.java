import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hust on 2018/2/6.
 */
public class Day30_test1 {
    public static void main(String[] args) throws SQLException {
        update();
    }

    private static Connection con;

    private static void update() throws SQLException {
        con = JDBCUtilsConfig.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "UPDATE student SET nscore=? WHERE sid=?";
        Object[] pram = {100,1};
        int line = queryRunner.update(con,sql,pram);
        System.out.println(line);
        DbUtils.closeQuietly(con);
    }
}
