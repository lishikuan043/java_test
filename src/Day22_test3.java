import java.io.File;

/**
 * Created by Administrator on 2018/1/8.
 * 从键盘接收一个文件夹路径,删除该文件夹。
 * args: E:\Java_test\resource\Empty_floder
 *
 * 注意：
 * 1.java的删除不经过回收站。
 * 2.java的File类的delete不能删除非空文件夹，若删除非空文件夹则会返回false。
 */
public class Day22_test3 {
    public static void main(String[] args) {
        File path = new File(args[0]);
        Boolean b = path.delete();
        System.out.println(b);
    }
}
