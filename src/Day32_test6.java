import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/1.
 * 定义一个标准的JavaBean，名叫Person，包含属性name、age。
 使用反射的方式创建一个实例、调用构造函数初始化name、age，使用反射方式调用setName方法对名称进行设置，
 不使用setAge方法直接使用反射方式对age赋值。
 */
public class Day32_test6 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("Student");
        Constructor constructor = c.getConstructor(String.class,String.class,int.class);
        Object obj = constructor.newInstance("bad","hello",1);
        System.out.println(obj);
        Method method = c.getMethod("setName", String.class);
        method.invoke(obj,"better");
        System.out.println(obj);
        Field field = c.getDeclaredField("age");
        field.setAccessible(true);
        field.set(obj,10);
        System.out.println(obj);

    }

}
