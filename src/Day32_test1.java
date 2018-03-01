import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by hust on 2018/3/1.
 * 1.ArrayList<Integer> list = new ArrayList<Integer>();
 * 这个泛型为Integer的ArrayList中存放一个String类型的对象.
 */
public class Day32_test1 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        Class c = arrayList.getClass();
        Method method = c.getMethod("add", Object.class);
        method.invoke(arrayList,"hello");
        System.out.println(arrayList);
    }
}
