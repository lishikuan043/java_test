import java.io.File;

/**
 * Created by Administrator on 2018/1/8.
 * 从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 例如:
 aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,打印出层级来
 aaa
     bbb.txt
     ccc.txt
     ddd.txt
     eee
        fff.txt
        ggg.txt

 * args: E:\Java_test\resource
 */
public class Day22_test4 {
    private void listFlie(File path, int deep) {
        //System.out.println(path);
        File[] files = path.listFiles();
        if (files != null) {
            for (File f :files) {
                for (int j = 0; j < deep; j++) {
                    System.out.print("\t");
                }
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
                if (f.isDirectory()) {
                    System.out.println(f.getName());
                    listFlie(f,deep+1);
                }
            }
        }

    }

    public static void main(String[] args) {
        Day22_test4 d4 = new Day22_test4();
        File file = new File(args[0]);
        System.out.println(args[0]);
        d4.listFlie(file,1);
    }
}
