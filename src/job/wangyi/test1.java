package job.wangyi;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        char now = 'N';
        for (int i = 0; i < chars.length; i++) {
            now = getNowchar(now,chars[i]);
        }
        System.out.println(now);
    }

    private static char getNowchar(char now, char move) {
        if (now == 'N') {
            if (move == 'L') return 'W';
            if (move == 'R') return 'E';
        }else if (now == 'W') {
            if (move == 'L') return  'S';
            if (move == 'R') return 'N';
        }else if (now == 'S') {
            if (move == 'L') return  'E';
            if (move == 'R') return 'W';
        } else if (now == 'E') {
            if (move == 'L') return 'N';
            if (move == 'R') return 'S';
        }
        return now;
    }
}
