package job.toutiao;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        for (String s :strings) {
            printInt(caculate(s));
        }
    }

    private static int caculate(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int temp = 0;
        char last = '+';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                sum = sum + temp;
                temp = 0;
                last = '+';
            }else if (chars[i] == '-') {
                sum = sum - temp;
                temp = 0;
                last = '-';
            }else {
                temp = temp*10 + 6;
            }
        }
        if (last == '+') {
            sum = sum + temp;
        }
        if (last == '-') {
            sum = sum + temp;
        }
        return sum;
    }

    private static void printInt(int i) {
        char[] chars = String.valueOf(i).toCharArray();
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        StringBuffer stringBuffer5 = new StringBuffer();

        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        for (int j = 0; j < chars.length; j++) {
            if (j != chars.length-1) {
                s1 = stringBuffer1.append(append(chars[j],1)).append("..").toString();
            }else {
                s1 = stringBuffer1.append(append(chars[j],1)).toString();
            }
            //stringBuffer1 = new StringBuffer();
            if (j != chars.length-1) {
                s2 = stringBuffer2.append(append(chars[j],2)).append("..").toString();
            }else {
                s2 = stringBuffer2.append(append(chars[j],2)).toString();
            }
            //stringBuffer2 = new StringBuffer();
            if (j != chars.length-1) {
                s3 = stringBuffer3.append(append(chars[j],3)).append("..").toString();
            }else {
                s3 = stringBuffer3.append(append(chars[j],3)).toString();
            }
            //stringBuffer3 = new StringBuffer();
            if (j != chars.length-1) {
                s4 = stringBuffer4.append(append(chars[j],4)).append("..").toString();
            }else {
                s4 = stringBuffer4.append(append(chars[j],4)).toString();
            }
            //stringBuffer4 = new StringBuffer();
            if (j != chars.length-1) {
                s5 = stringBuffer5.append(append(chars[j],5)).append("..").toString();
            }else {
                s5 = stringBuffer5.append(append(chars[j],5)).toString();
            }
            //stringBuffer5 = new StringBuffer();

        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }

    private static String append(char c,int row) {
        String s = "";
        if (row == 1) {
            switch (c) {
                case '0': s = "66666"; break;
                case '2': s = "66666"; break;
                case '4': s = "6...6";break;
                case '6': s = "66666";break;
                case '8': s = "66666";break;
            }
        }
        if (row == 2) {
            switch (c) {
                case '0': s = "6...6";break;
                case '2': s = "....6";break;
                case '4': s = "6...6";break;
                case '6': s = "6....";break;
                case '8': s = "6...6";break;
            }
        }
        if (row == 3) {
            switch (c) {
                case '0': s = "6...6";break;
                case '2': s = "66666";break;
                case '4': s = "66666";break;
                case '6': s = "66666";break;
                case '8': s = "66666";break;
            }
        }
        if (row == 4) {
            switch (c) {
                case '0': s = "6...6";break;
                case '2': s = "6....";break;
                case '4': s = "....6";break;
                case '6': s = "6...6";break;
                case '8': s = "6...6";break;
            }
        }
        if (row == 5) {
            switch (c) {
                case '0': s = "66666";break;
                case '2': s = "66666";break;
                case '4': s = "....6";break;
                case '6': s = "66666";break;
                case '8': s = "66666";break;
            }
        }
        return s;
    }
}
