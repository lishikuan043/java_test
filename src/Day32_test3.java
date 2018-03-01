import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/1.
 * 编写一个类，增加一个实例方法用于打印一条字符串。
 * 并使用反射手段创建该类的对象，并调用该对象中的方法。
 */
public class Day32_test3 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("Student");
        Object obj = c.newInstance();
        //1
        Student student = (Student)obj;
        student.printOut("method1.");
        //2
        Method method = c.getMethod("printOut",String.class);
        method.invoke(obj,"method2.");

    }
}
