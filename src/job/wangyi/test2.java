package job.wangyi;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] x1 = scanner.nextLine().split(" ");
        String[] y1 = scanner.nextLine().split(" ");
        String[] x2 = scanner.nextLine().split(" ");
        String[] y2 = scanner.nextLine().split(" ");
        int count = 1;
        int temp = 1;
        area[] areas = new area[num];
        for (int i = 0; i < num; i++) {
            areas[i] = new area(Integer.parseInt(x1[i]),Integer.parseInt(y1[i]),
            Integer.parseInt(x2[i]),Integer.parseInt(y2[i]));
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (areas[i].inarea(areas[j].getpoint1())) {
                    count++;
                    break;
                }
                if (areas[i].inarea(areas[j].getpoint2())) {
                    count++;
                    break;
                }
                if (areas[i].inarea(areas[j].getpoint3())) {
                    count++;
                    break;
                }
                if (areas[i].inarea(areas[j].getpoint4())) {
                    count++;
                    break;
                }
            }
            if (count > temp) {
                temp = count;
                count = 1;
            }
        }
        System.out.println(temp);
    }

    private static class area {
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public area(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        private boolean inarea(int[] ints) {
            if (ints[0] > x1 && ints[0] < x2 && ints[1] > y1 && ints[1] < y2) {
                return true;
            }else {
                return false;
            }
        }

        private int[] getpoint1() {
            int[] point = {x1,y1};
            return point;
        }
        private int[] getpoint2() {
            int[] point = {x1,y2};
            return point;
        }
        private int[] getpoint3() {
            int[] point = {x2,y1};
            return point;
        }
        private int[] getpoint4() {
            int[] point = {x2,y2};
            return point;
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(x1 + " " + y1 + " ");
            stringBuffer.append(x1 + " " + y2 + " ");
            stringBuffer.append(x2 + " " + y1 + " ");
            stringBuffer.append(x2 + " " + y2 + " ");
            return stringBuffer.toString();
        }
    }
}
