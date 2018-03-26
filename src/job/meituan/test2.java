package job.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        put(hashMap, input);
        boolean flag = false;
        for (int i = 1;!flag && i < 10; i++) {
            char c = String.valueOf(i).charAt(0);
            if (!hashMap.containsKey(c)) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag && hashMap.get('0') == 0) {
            System.out.println(10);
        }

       while(true) {
            int i = 11;
            HashMap<Character,Integer> hashMap1 = new HashMap<>();
            String s = String.valueOf(i);
            put(hashMap1, s);
            for (char c :
                    hashMap1.keySet()) {
                if (hashMap1.get(c) > hashMap.get(c)) {
                     int temp = hashMap.get(c);
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int j = 0; j < temp+1; j++) {
                        stringBuffer.append(c);
                    }
                    System.out.println(stringBuffer.toString());
                    break;
                }
            }
            i++;
        }

    }

    private static void put(HashMap<Character, Integer> hashMap, String s) {
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c,1);
            } else {
                hashMap.put(c,hashMap.get(c)+1);
            }
        }
    }
}
