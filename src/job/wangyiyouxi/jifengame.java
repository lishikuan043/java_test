package job.wangyiyouxi;

import java.util.Scanner;
import java.util.TreeMap;

public class jifengame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int[] ints = new int[strings.length];
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
            if (!treeMap.containsKey(ints[i])) {
                treeMap.put(ints[i],1);
            }else {
                treeMap.put(ints[i],treeMap.get(ints[i])+1);
            }
        }
        //System.out.println(treeMap);
        int result = 0;
        int tempscore = 0;
        int usepre = 0;
        int notusepre = 0;
        //int usenow = 0;
        //int notusenow = 0;
        Integer[] array = new Integer[treeMap.keySet().size()];
        treeMap.keySet().toArray(array);
        usepre = array[0]*treeMap.get(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i-1] != 1) {
                notusepre = Math.max(usepre,notusepre);
                usepre = Math.max(usepre,notusepre) + array[i]*treeMap.get(array[i]);
            }else {
                tempscore = usepre;
                usepre = notusepre + array[i]*treeMap.get(array[i]);
                notusepre = Math.max(tempscore,notusepre);
            }
        }
        result = Math.max(usepre,notusepre);
        System.out.println(result);
    }
}
