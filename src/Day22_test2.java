import java.io.*;

/**
 * Created by Administrator on 2018/1/8.
 * 从键盘接收一个文件夹路径,统计该文件夹大小。
 * args:  E:\Java_test\resource
 */
public class Day22_test2 {

    private long getSize(String filename) {
        long size = 0;
        File path = new File(filename);
        File[] files = path.listFiles();
        for (File file:files) {
            if (file.isFile()) {
                size += file.length();
            }
            if (file.isDirectory()) {
                size += getSize(file.getName());
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Day22_test2 day22_test2 = new Day22_test2();
        System.out.println(day22_test2.getSize(args[0]));
    }
}
