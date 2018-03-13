package job.niuke_test1;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] ints = new int[length];
        String string  = scanner.nextLine();
        String[] strings = string.split(" ");
        for(int i=0;i<length;i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int mod = length%2;
        int[] result = new int[length];
        if(mod == 0) {
            int midpos = length/2;
            for(int j=0;j<length;j++) {
                if(j%2 == 1){
                    result[midpos-(j/2+1)] = ints[j];
                } else{
                    result[midpos+(j/2)] = ints[j];
                }
            }
        } else {
            int midpos = length/2;
            for(int j=0;j<length;j++) {
                if (j==0) {
                    result[midpos] = ints[j];
                }else if(j%2 == 1){
                    result[midpos+(j/2)+1] = ints[j];
                } else{
                    result[midpos-(j/2)] = ints[j];
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int k=0;k<length-1;k++) {
            sb.append(result[k]);
            sb.append(" ");
        }
        sb.append(result[length-1]);
        System.out.println(sb.toString());
    }
}
