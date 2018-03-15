package test;
//一个整形数组，找到其中两个数，其加起来值为某个特定的数值。假设数组中只有一对数可以满足此条件，返回这两个数在数组中的位置。

import java.util.*;

public class test1 {
    public static int[] find(int[]ints,int target) {
        int[] result = new int[2];
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] + ints[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] find1(int[] ints,int target) {
        int[] anotherInts = new int[ints.length];
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int k :
                ints) {
            list.add(k);
            //System.out.println(k);
        }
        //System.out.println(arrayList);
        for (int i = 0; i < ints.length; i++) {
            anotherInts[i] = target - ints[i];
            int j = list.indexOf(anotherInts[i]);
            if (j != -1) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        int target = 4;
        int[] result = new int[2];
        result = find1(ints,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
