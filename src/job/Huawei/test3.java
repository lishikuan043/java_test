package job.Huawei;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int count = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] nowchars1= {},nowchars2 = {};
        if (chars1[0] == '-') {
            count++;
            nowchars1 = s1.substring(1,s1.length()).toCharArray();
        }else {
            nowchars1 = chars1;
        }
        if (chars2[0] == '-') {
            count++;
            nowchars2 = s2.substring(1,s2.length()).toCharArray();
        }else {
            nowchars2 = chars2;
        }
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (char c :
                nowchars1) {
            sb1.append(c);
        }
        long l1 = Long.parseLong(sb1.toString());
        for (char c :
                nowchars2) {
            sb2.append(c);
        }
        long l2 = Long.parseLong(sb2.toString());
        if (count==1) {
            System.out.print("-");
        }
        long result = l1*l2;
        System.out.println(result);
    }
}
