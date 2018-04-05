package job.wangyiyouxi;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] widths = scanner.nextLine().split(" ");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int temp = 0;
        int now = 0;
        int row = 1;
        for (int i = 0; i < chars.length; i++) {
            if (temp+getwidth(chars[i],widths) <= 100) {
                temp += getwidth(chars[i],widths);
            }else {
                row++;
                //now = temp;
                temp = getwidth(chars[i],widths);
            }
        }
        System.out.print(row + " " + temp);
    }
    public static int getwidth(char c,String[] strings) {
        int x = c - 'a';
        return Integer.parseInt(strings[x]);
    }
}
