import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by Administrator on 2018/3/1.
 * 已知一个类，定义如下：
 package com.itheima;
 public class DemoClass {
 public void run() {
 System.out.println("welcome to heima!");
 }
 }
 (1)写一个Properties格式的配置文件，配置类的完整名称。
 (2) 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，
 (3)用反射 的方式运行run方法。
 */
public class Day32_test7 {
    public static void main(String[] args) throws Exception{
        FileReader fileReader = new FileReader("E:\\Java_test\\resource\\Day32.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        String s = properties.getProperty("ClassName");
        Class c = Class.forName(s);
        Method method = c.getMethod("run");
        Object object = c.newInstance();
        method.invoke(object);
    }
}
