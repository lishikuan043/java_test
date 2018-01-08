import java.io.File;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/8.
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数,注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
 用个数作为value,放入到map集合中,并用两种方式遍历map集合
 例如：
 doc 的类型的文件有  1 个
 java 的类型的文件有  1 个
 txt 的类型的文件有  2 个
 jpg 的类型的文件有  1 个
 */
public class Day22_test5 {
    private HashMap<String,Integer> hashMap = new HashMap<>();
    private void listFlie(File path) {
        File[] files = path.listFiles();
        if (files != null) {
            for (File f :files) {
                if (f.isFile()) {
                    putInmap(f.getName());
                }
                if (f.isDirectory()) {
                    listFlie(f);
                }
            }
        }

    }

    private void putInmap(String name) {
        String type = name.substring(name.indexOf(".")+1,name.length());
        if (hashMap.containsKey(type)) {
            hashMap.put(type,hashMap.get(type) + 1);
        } else {
            hashMap.put(type,1);
        }
    }

    public static void main(String[] args) {
        Day22_test5 d5 = new Day22_test5();
        File file = new File(args[0]);
        System.out.println(args[0]);
        d5.listFlie(file);
        System.out.println(d5.hashMap);
    }
}
