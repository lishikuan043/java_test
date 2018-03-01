import java.lang.reflect.Constructor;

/**
 * Created by hust on 2018/3/1.
 * 用反射去创建一个对象，有2种方式，尽量用代码去体现
 */
public class Day32_test2 {
    public static void main(String[] args) throws Exception {
        //1
        Student student = new Student();
        Class c1 = student.getClass();
        Object student1 = c1.newInstance();
        Student s1 = (Student)student1;
        System.out.println(c1 + s1.toString());
        //2
        Class c2 = Class.forName("Student");
        Constructor constructor = c2.getConstructor();
        Object student2 = constructor.newInstance();
        Student s2 = (Student)student2;
        System.out.println(c2 + s2.toString());

    }
}
