import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/1/10.
 * list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫,写入到"E:\Java_test\resource\stuinfo.txt"
 */
public class Day23_test5 {
    public static void main(String[] args) {
        LinkedList<String> nameList = new LinkedList<>();
        nameList.add("张三");
        nameList.add("李四");
        nameList.add("王五");
        String target = "E:\\Java_test\\resource\\stuinfo.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(target);
            for (String s:nameList) {
                fileWriter.write(s);
                fileWriter.write(" ");
                System.out.println("Write " + s + " to " + target);
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
