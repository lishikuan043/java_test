package itheima;

/**
 * Created by Administrator on 2018/3/1.
 */
public class DemoClass {
    private String name =  "old";
    public void run() {
        System.out.println("welcome to heima!");
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
