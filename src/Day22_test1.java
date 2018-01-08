import java.io.*;

/**
 * Created by Administrator on 2018/1/5.
 * 使用文件名称过滤器筛选将指定文件夹下的小于200K的小文件获取并打印。
 * args:  E:\Java_test\resource
 */
public class Day22_test1 {
    private static class myFilefilter implements FileFilter{

        @Override
        public boolean accept(File pathname) {
            if (pathname.length() < 200*1024) {
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        File[] files = file.listFiles(new myFilefilter());
        for (File f:files) {
            System.out.println(f.getName());
        }
    }
}
