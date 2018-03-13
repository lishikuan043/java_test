package job.niuke_test1;

import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] ints = new int[length];
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        for(int i=0;i<length;i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        quickSort(ints,0,ints.length-1);
        System.out.println(check(ints));
    }

    private static String check(int[] ints) {
        int cha = ints[1] - ints[0];
        for(int i = 0;i < ints.length-1;i++) {
            if (ints[i+1] - ints[i] != cha) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static void quickSort(int[] ints, int low, int high) {
        int key = ints[low];
        int l = low;
        int h = high;
        while(l<h) {
            while(l < h&&ints[h] >= key) {
                h--;
            }
            if (l < h) {
                ints[l] = ints[h];
                l++;
            }
            while(l < h&&ints[l] <= key) {
                l++;
            }
            if(l < h) {
                ints[h] = ints[l];
                h--;
            }
            ints[l] = key;
            if (low < l) {
                quickSort(ints,low,l-1);
            }
            if (high > h) {
                quickSort(ints,h+1,high);
            }
        }
    }
}
