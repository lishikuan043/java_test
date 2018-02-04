import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hust on 2018/2/4.
 */
public class Day29_test2 {
    private static Connection con;

    private static void test1() throws Exception{
        String sql1 = "SELECT COUNT(*) FROM student WHERE nsex='女' AND nscore>80";
        Statement statement1 = con.createStatement();
        ResultSet rs1 = statement1.executeQuery(sql1);
        while(rs1.next()) {
            System.out.println(rs1.getInt(1));
        }
        statement1.close();
    }

    private static void test2() throws Exception {
        String sql2 = "UPDATE student SET nscore=100 WHERE sname REGEXP '^张' AND nsex='男'";
        Statement statement2 = con.createStatement();
        int line = statement2.executeUpdate(sql2);
        System.out.println(line + " changes!");
        statement2.close();
    }

    private static void test3() throws Exception {
        String sql3 = "SELECT sname,nsex,nscore FROM student WHERE nsex='女' AND nscore>60";
        Statement statement3 = con.createStatement();
        ResultSet rs3 = statement3.executeQuery(sql3);
        while(rs3.next()) {
            System.out.println(rs3.getString("sname") + "  " + rs3.getString("nsex")
            + "  " + rs3.getString("nscore"));
        }
        statement3.close();
    }

    private static void test4() throws Exception {
        String sql4_1 = "SELECT AVG(nscore) FROM student WHERE nsex='男'";
        Statement statement4 = con.createStatement();
        ResultSet rs4 = statement4.executeQuery(sql4_1);
        while (rs4.next()) {
            System.out.println(rs4.getDouble(1));
        }
        statement4.close();
    }

    private static void test5() throws Exception {
        String sql5 = "SELECT * FROM student WHERE nscore>(SELECT AVG(nscore) FROM student) ORDER BY nscore";
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Java_test\\resource\\StudentInfo_2.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        Statement statement5 = con.createStatement();
        ResultSet rs5 = statement5.executeQuery(sql5);
        while (rs5.next()) {
            System.out.println(rs5.getInt("sid") + "  " + rs5.getString("sname") + "  " + rs5.getString("nsex")
                    + "  " + rs5.getInt("nscore"));
            printWriter.println(rs5.getInt("sid") + "  " + rs5.getString("sname") + "  " + rs5.getString("nsex")
                    + "  " + rs5.getInt("nscore"));
        }
        printWriter.close();
        statement5.close();
    }

     private static ArrayList<student> arrayList = new ArrayList<>();

    public static List<student> getAllstudent() throws Exception {

        String sql6 = "SELECT * FROM student";
        Statement statement6 = con.createStatement();
        ResultSet rs5 = statement6.executeQuery(sql6);
        while (rs5.next()) {
            System.out.println(rs5.getInt("sid") + "  " + rs5.getString("sname") + "  " + rs5.getString("nsex")
                    + "  " + rs5.getInt("nscore"));
            arrayList.add(new student(rs5.getInt("sid"),rs5.getString("sname"),rs5.getString("nsex"),rs5.getInt("nscore")));
        }
        statement6.close();
        return arrayList;

    }

    public static student getStudentById(int id){
        student student1 = null;
        for (student s :
                arrayList) {
            if (s.sid == id) {
                student1 = s;
                //System.out.println(s);
            }
        }
        return student1;
    }

    private static boolean haveId(int id) throws Exception {
        String sql = "SELECT * FROM student WHERE sid=?";
        PreparedStatement psta9 = con.prepareStatement(sql);
        psta9.setString(1,Integer.toString(id));
        ResultSet rs = psta9.executeQuery();
        boolean b = rs.next();
        psta9.close();
        return b;
    }

    public static void deleteStudentById(int id) throws Exception {
        if (haveId(id)) {
            String sql8 = "DELETE FROM student WHERE sid=?";
            PreparedStatement psta = con.prepareStatement(sql8);
            psta.setString(1,Integer.toString(id));
            int line = psta.executeUpdate();
            System.out.println(line + "  changes!");
            psta.close();
        } else {
            System.out.println("Don't exist!");
        }
    }

    public static void addStudent(student s) throws Exception{
        if (arrayList.contains(s)) {
            System.out.println("Already exist!");
        } else {
            String sql9 = "INSERT INTO student(sid,sname,nsex,nscore) VALUES (?,?,?,?)";
            PreparedStatement psta = con.prepareStatement(sql9);
            psta.setString(1,Integer.toString(s.sid));
            psta.setString(2,s.sname);
            psta.setString(3,s.nsex);
            psta.setString(4,Integer.toString(s.nscore));
            int line = psta.executeUpdate();
            System.out.println(line + "  changes!");
            psta.close();
        }
    }

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day29_jdbc";
        String username = "root";
        String password = "043043";
        con = DriverManager.getConnection(url,username,password);
        test1();
        test2();
        test3();
        test4();
        test5();
        getAllstudent();
        for (student s :
                arrayList) {
            System.out.println(s);
        }
        getStudentById(1);

        student student1 = new student(11,"lsk","男",101);
        System.out.println(student1);
        deleteStudentById(11);
        addStudent(student1);
        deleteStudentById(11);
        deleteStudentById(11);


        con.close();
    }

private static class student{
    int sid;
    String sname;
    String nsex;
    int nscore;

    public student(int sid, String sname, String nsex, int nscore) {
        this.sid = sid;
        this.sname = sname;
        this.nsex = nsex;
        this.nscore = nscore;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", nsex='" + nsex + '\'' +
                ", nscore=" + nscore +
                '}';
    }
}

}
