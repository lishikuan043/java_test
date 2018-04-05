package job.zhaohang;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int l = s.length();
        String ss = s+s;
        int n = 0;
        int length = 0;
        boolean flag = false;
        for (int i = 1; i < l; i++) {
            String s1 = ss.substring(i,i+l);
            if (s1.equals(s)) {
                length = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(s.substring(0,length));
        }else System.out.println(flag);

    }
}
