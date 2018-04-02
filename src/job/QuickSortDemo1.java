package job;

public class QuickSortDemo1 {
    public static void sort(int[] array,int low,int high){
        int key = array[low];
        int l = low;
        int h = high;
        while(l<h) {
            while (l<h && array[h] > key) {
                h--;
            }
            if (l < h) {
                array[l] = array[h];
                l++;
            }
            while (l<h && array[l] < key) {
                l++;
            }
            if (l < h) {
                array[h] = array[l];
                h--;
            }
        }
        array[l] = key;
        if (low < l-1) {
            sort(array,low,l-1);
        }
        if (high > h + 1) {
            sort(array,h+1,high);
        }
    }


    public static void main(String[] args) {
        int[] ints = {1,2,5,3,8,4,8,9,10,6,6546,1321,48,54};

        sort(ints,0,ints.length-1);
        for(int i:ints) {
            System.out.print(i + "  ");
        }


    }
}
