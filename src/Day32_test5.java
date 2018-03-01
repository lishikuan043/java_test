import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/3/1.
 * 写一个方法，此方法可将obj对象中名为propertyName的属性的值设置为value.
 public void setProperty(Object obj, String propertyName, Object value){
 }
 */
public class Day32_test5 {

    public static void setProperty(Object obj, String propertyName, Object value) throws Exception{
        Class c = Class.forName("testC");
        Field field = c.getField(propertyName);
        field.set(obj,value);
    }

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("testC");
        Object object = c.newInstance();
        setProperty(object,"Name","lsk");
        System.out.println(object);
    }
}

class testC {
    public String Name;
    public String toString() {
        return Name;
    }
}