import itheima.DemoClass;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/3/1.
 * 写一个方法，此方法可以获取obj对象中名为propertyName的属性的值
 public Object getProperty(Object obj, String propertyName, Object value){

 }
 */
public class Day32_test8 {
    public static void main(String[] args)throws Exception {
        Class c = Class.forName("itheima.DemoClass");
        Object demoClass = c.newInstance();
        System.out.println(demoClass);
        System.out.println(getProperty(demoClass,"Name"));
    }

    public static Object getProperty(Object obj, String propertyName) throws Exception{
        Class c = obj.getClass();
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        Object o = field.get(obj);
        return o;
    }
}
