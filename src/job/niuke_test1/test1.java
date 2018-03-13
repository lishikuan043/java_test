package job.niuke_test1;

import java.util.HashSet;
import java.util.Scanner;

public class test1 {
    public static int getresult1(String s) {
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for(char c:chars) {
            charSet.add(c);
        }
        if (charSet.size() == 1) {
            return 1;
        }else if (charSet.size() ==2) {
            return 2;
        }else return 0;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getresult1(s));
    }
}
