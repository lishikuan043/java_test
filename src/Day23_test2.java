import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/10.
 * 获取指定目录及子目录下所有txt文件的个数，并将这些txt文件复制到D盘下任意目录
 * 注：重名文件将覆盖，D盘位置可更改
 */
public class Day23_test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        File file = new File(path);
        findtxt(file);
    }

    private static void findtxt(File file) {
        File[] files = file.listFiles();
        for (File f:files) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                copy(f.getAbsolutePath(),f.getName());
                System.out.println("Copy " + f.getAbsolutePath() + " succeed!");
            }
            if (f.isDirectory()) {
                findtxt(f);
            }
        }
    }

    private static void copy(String source,String filename) {
        String target = "D:\\test\\" + filename;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(source);
            fileWriter = new FileWriter(target);
            char[] cbuf = new char[1024];
            int length = 0;
            while ((length = fileReader.read(cbuf)) != -1) {
                fileWriter.write(cbuf);
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e1) {
                System.out.println(e1);
            } finally {
                try {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException e2) {
                    System.out.println(e2);
                }
            }
        }
    }
}
