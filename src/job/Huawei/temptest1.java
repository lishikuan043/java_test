package job.Huawei;

import java.util.HashSet;
import java.util.Scanner;

public class temptest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            for (char c :
                    chars) {
                if (!hashSet.contains(c)) {
                    //System.out.print(c);
                    hashSet.add(c);
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
