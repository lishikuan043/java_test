package job.niuke_test1;

import java.util.Scanner;

public class tets3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int[] ints = new int[string.length()];
        String[] strings = string.split("");
        for(int i=0;i<string.length();i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int max = 1;
        int temp = 1;
        if(string.length() == 1) {
            System.out.println(1);
        } else {
            for(int j = 0;j<string.length()-1;j++) {
                if((ints[j+1]+ints[j]) != 1) {
                    temp = 1;
                } else {
                    temp++;
                    if(temp >= max) {
                        max = temp;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
