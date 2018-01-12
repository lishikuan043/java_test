import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/1/12.
 * 用代码实现以下需求
 (1)定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,生成空参有参构造,set和get方法,toString方法
 (2)键盘录入6个学员信息(录入格式:张三,男,25),要求有两个相同的信息,将6个学员信息存入到ArrayList集合中
 (3)将存有6个学员信息的ArrayList集合对象写入到E:\Java_test\resource\StudentInfo.txt文件中
 (4)读取E:\Java_test\resource\StudentInfo.txt文件中的ArrayList对象
 (5)对ArrayList集合中的6个学生对象进行去重并按照年龄从小到大的顺序排序
 (6)将ArrayList集合中排序后的结果利用PrintWriter流写入到E:\Java_test\resource\StudentInfo_1.txt文件中(写入格式：张三-男-25)
 */
public class Day25_test1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第" + (i+1) + "个学员信息：");
            input = scanner.next();
            String[] strings = input.split("，");
            Student student = new Student(strings[0],strings[1],Integer.valueOf(strings[2]));
            arrayList.add(student);
        }
        FileOutputStream fos = new FileOutputStream("E:\\Java_test\\resource\\StudentInfo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayList);
        oos.close();
        System.out.println("保存成功！");

        FileInputStream fis = new FileInputStream("E:\\Java_test\\resource\\StudentInfo.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);



    }
}