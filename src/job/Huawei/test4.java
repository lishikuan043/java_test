package job.Huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String,String> map = new TreeMap<>();
        String sname = null;
        //String s = scanner.nextLine();
        //while(!s.equals("123")) {
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            if (s.startsWith(";")) {

            }else if (s.startsWith("[section")) {
                if (!map.isEmpty()){
                    printMap(sname,map);
                    map.clear();
                }
                sname = getsectionName(s);
            }else {
               String key =  getKeyValue(s)[0];
               String value =  getKeyValue(s)[1];
               map.put(key,value);
            }
            //s = scanner.nextLine();
        }
        printMap(sname,map);
    }

    private static void printMap(String sname,TreeMap<String, String> map) {
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println("{" + sname + "}" + "{" + entry.getKey() + "}" + "{" + entry.getValue() + "}");
        }
    }

    private static String[] getKeyValue(String s) {
        String[] strings = new String[2];
        String s1 = s.split(";")[0];
        //System.out.println(s1);
        String key = s1.split("=")[0];
        //System.out.println(key);
        String value = s1.split("=")[1];
        //System.out.println(value);
        strings[0] = key.trim();
        strings[1] = value.trim();
        return strings;
    }


    private static String getsectionName(String s) {
        String s1 = s.split(";")[0];
        s1 = s1.replace('[',' ');
        s1 = s1.replace(']',' ');
        return s1.trim();
    }
}
