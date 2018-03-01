import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/1.
 * 编写一个类A，增加一个实例方法showString,用于打印一条字符串，
 * 在编写一个类TestA ,作为客户端，用键盘输入一个字符串，该字符串就是类A的全名，使用反射机制创建该类的对象，
 * 并调用该对象中的方法showString
 */
public class Day32_test4 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Class c = Class.forName(input);
        Object obj = c.newInstance();
        Method method = c.getMethod("printOut",String.class);
        method.invoke(obj,"test4.");

    }
}
