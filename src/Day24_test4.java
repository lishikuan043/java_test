import java.io.*;

/**
 * Created by Administrator on 2018/1/11.
 * java写一个程序，实现从文件中读出文件内容，并将其打印在屏幕当中，并标注上行号
 * E:\Java_test\resource\floder\count.txt
 */
public class Day24_test4 {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Java_test\\resource\\floder\\count.txt";
        BufferedReader bfr = new BufferedReader(new FileReader(path));
        String line = null;
        int linenum = 1;
        while((line = bfr.readLine())!=null) {
            System.out.println(linenum++ + ":" + line);
        }
        bfr.close();
    }
}
