import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/11.
 * 用代码实现以下需求
 (1)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
 (2)打印格式：
 to=3
 think=1
 you=2
 //........
 (3)按照上面的打印格式将内容写入到E:\Java_test\resource\floder\count.txt文件中(要求用高效流)
 */
public class Day24_test2 {
    private static String S = "If you want to change your fate I think you must come to the dark horse to learn java";
    public static void main(String[] args) throws IOException{
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] strings = S.split(" ");
        for (String s:strings) {
            if (!hashMap.containsKey(s)) {
                hashMap.put(s,1);
            } else {
                hashMap.put(s,hashMap.get(s) + 1);
            }
        }
        BufferedWriter bfw = new BufferedWriter(new FileWriter("E:\\Java_test\\resource\\floder\\count.txt"));
        for (String s : hashMap.keySet()) {
            System.out.println(s + "=" + hashMap.get(s));
            bfw.write(s + "=" + hashMap.get(s));
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
    }
}
