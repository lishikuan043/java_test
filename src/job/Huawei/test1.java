package job.Huawei;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int maxLength = 0;
        StringBuffer resultBuffer = new StringBuffer();
        char[] chars = input.toCharArray();
        int tempLength = 0;
        StringBuffer tempBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                tempLength++;
                tempBuffer.append(chars[i]);
                if (tempLength >= maxLength) {
                    maxLength = tempLength;
                    resultBuffer = tempBuffer;
                }
            }else{
                tempLength = 0;
                tempBuffer = new StringBuffer();
            }
        }
        String result = resultBuffer.toString();
        System.out.println(result + "," + maxLength);
    }
}
