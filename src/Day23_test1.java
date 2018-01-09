import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/9.
 * 从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
 */
public class Day23_test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source floder:");
        String source = scanner.next();
        System.out.println("Input target floder:");
        String target = scanner.next();
        File sourceaddr = new File(source);
        File[] files = sourceaddr.listFiles();
        for (File f: files) {
            if (f.isFile()) {
                copyfile(f.getAbsolutePath(),target + "\\" + f.getName());
            }
        }

    }

    private static void copyfile(String absolutePath,String target) {
        System.out.println("Copy " + absolutePath + " to " + target);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(absolutePath);
            fileWriter = new FileWriter(target);
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = fileReader.read(cbuf)) != -1) {
                fileWriter.write(cbuf,0,len);
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            }catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    if (fileReader != null)
                        fileReader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
