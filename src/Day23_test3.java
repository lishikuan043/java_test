import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/10.
 * 键盘输入10个数，放到数组中
 (1)去除该数组中大于10的数
 (2)将该数组中的数字写入到本地文件number.txt中
 */
public class Day23_test3 {
    public static void main(String[] args) {
        int[] ints = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int num = 10 - i;
            System.out.println("Please input one number:( " + num + " more to be inputted)" );
            ints[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] <= 10) {
                ints[count] = ints[i];
                count ++;
            }
        }
        String target = "E:\\Java_test\\resource\\number.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(target);
            for (int i = 0; i < count ; i++) {
                fileWriter.write(String.valueOf(ints[i]));
                fileWriter.write(" ");
                System.out.println("Write " + ints[i] + " to " + target);
                fileWriter.flush();
            }
        }catch (IOException e) {
            System.out.println();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
    }
}
