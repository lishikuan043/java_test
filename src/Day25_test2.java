import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/13.
 * 用代码实现以下需求：
 (1)已知配置文件E:\Java_test\resource\config.properties中有三个键值对
    name=zhangsan
    score=80
    address=beijing
 (2)使用IO字节流对象和Properties类结合使用,将配置文件中的score键的值修改为100
 */
public class Day25_test2 {
    public static void main(String[] args) throws IOException{
        Properties properties = new Properties();
        properties.setProperty("name","zhangsan");
        properties.setProperty("score","80");
        properties.setProperty("address","beijing");
        FileOutputStream fos = new FileOutputStream("E:\\Java_test\\resource\\config.properties");
        properties.store(fos,"");
        fos.close();

        FileInputStream fis = new FileInputStream("E:\\Java_test\\resource\\config.properties");
        Properties properties1 = new Properties();
        properties1.load(fis);
        properties1.setProperty("score","100");
        fis.close();
        FileOutputStream fos1 = new FileOutputStream("E:\\Java_test\\resource\\config.properties");
        properties1.store(fos1,"Change score.");
        fos1.close();


    }
}

