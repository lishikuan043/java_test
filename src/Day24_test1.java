import java.io.*;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/11.
 * 将前面作业中关于文件拷贝的操作，替换为高效流
 * 修改Day23_test6
 */
public class Day24_test1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source floder:");
        String source = scanner.next();
        //System.out.println("Input target floder:");
        String target = "E:\\Java_test\\resource\\floder\\";
        File sourceaddr = new File(source);
        File[] files = sourceaddr.listFiles();
        for (File f: files) {
            if (f.isFile() && f.getName().endsWith(".java")) {
                copyfile(f.getAbsolutePath(),target  + f.getName());
            }
        }

    }

    private static void copyfile(String absolutePath,String target) throws IOException{
        System.out.println("Copy " + absolutePath + " to " + target);
        FileReader fileReader = new FileReader(absolutePath);
        FileWriter fileWriter = new FileWriter(target);
        BufferedReader bfr = new BufferedReader(fileReader);
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        String line = null;
        while((line = bfr.readLine()) != null) {
            bfw.write(line);
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
        bfr.close();
    }
}
