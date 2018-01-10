import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Administrator on 2018/1/10.
 * 产生10个1-100的随机数，并放到一个数组中
 (1)把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
 (2)把数组中的数字放到当前文件夹的number.txt文件中
 */
public class Day23_test4 {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = random.nextInt(100);
            if (ints[i] > 10) {
                list.add(ints[i]);
                System.out.println(ints[i]);
            }
        }

        String target = "E:\\Java_test\\resource\\number.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(target);
            for (int i = 0; i < ints.length ; i++) {
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
