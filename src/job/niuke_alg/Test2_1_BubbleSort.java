package job.niuke_alg;

public class Test2_1_BubbleSort {
    public static int[] bubbleSort(int[] A, int n) {
        int[] copy = new int[n];
        System.arraycopy(A,0,copy,0,n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (copy[j] > copy[j+1]) {
                    int temp = copy[j];
                    copy[j] = copy[j+1];
                    copy[j+1] = temp;
                }
            }
        }
        return copy;
    }

    public static int[] selectionSort(int[] A, int n) {
        int[] copy = new int[n];
        System.arraycopy(A,0,copy,0,n);
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                if (copy[i] > copy[j]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        return copy;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,5,2,3};
        for (int i :selectionSort(A,A.length)){
            System.out.print(i);
        }
    }
}
