package job;

public class QuickSortDemo {
    public static void quickSort(int[] ints,int start,int end) {
        int key = ints[start];
        int l = start;
        int h = end;
        while (l < h) {
            while (l < h&&ints[h] >= key) {
                h--;
            }
            if (l < h) {
                ints[l] = ints[h];
                l++;
            }
            while (l < h&&ints[l] <= key) {
                l++;
            }
            if (l < h) {
                ints[h] = ints[l];
                h--;
            }
        }
        ints[l] = key;
        if (l>start) {
            quickSort(ints,start,l-1);
        }
        if (end>l) {
            quickSort(ints,h+1,end);
        }

    }

    public static void main(String[] args) {
        int[] ints = {2,5,3,8,4,10,6,6546,1321,48,54};

        quickSort(ints,0,ints.length-1);
        for(int i:ints) {
            System.out.print(i + ",");
        }

    }

}
