package job.Huawei;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int uiIutputLen = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int uiElementNum = Integer.parseInt(scanner.nextLine());
        int[] ints = new int[uiElementNum];
        for (int i = 0; i < uiElementNum; i++) {
            ints[i] = Integer.parseInt(scanner.nextLine());
        }
        String[] strings = input.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String s :
                strings) {
            char[] chars = s.toCharArray();
            stringBuffer.append(sixteentodouble(chars[2]));
            stringBuffer.append(sixteentodouble(chars[3]));
        }
        String result = stringBuffer.toString();
        int start = 0;
        int end = 0;
        for (int i = 0; i < uiElementNum; i++) {
            end = start + ints[i] - 1;
            System.out.println(doubuletoten(result,start,end));
            start = end + 1;
        }
    }

    private static long doubuletoten(String result,int start, int end) {
        long out = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= end; i++) {
            sb.append(result.split("")[i]);
        }
        String s = sb.toString();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            out +=(Math.pow(2,i))*(Integer.parseInt(String.valueOf(chars[chars.length-i-1])));
        }
        return out;
    }

    private static String sixteentodouble(char aChar) {
        switch (aChar) {
            case '0': return "0000";
            case '1': return "0001";
            case '2': return "0010";
            case '3': return "0011";
            case '4': return "0100";
            case '5': return "0101";
            case '6': return "0110";
            case '7': return "0111";
            case '8': return "1000";
            case '9': return "1001";
            case 'a': return "1010";
            case 'b': return "1011";
            case 'c': return "1100";
            case 'd': return "1101";
            case 'e': return "1110";
            case 'f': return "1111";
            default: return "";
        }
    }
}
