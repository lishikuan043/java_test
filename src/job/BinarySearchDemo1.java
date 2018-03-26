package job;


public class BinarySearchDemo1 {


    public static void main(String[] args) {
        int[] ints = {1,2,3,3,3,3,3,5,6,7,9};
        int target = 3;
        System.out.println(lowbinarySearch(ints,target));
    }

    private static int lowbinarySearch(int[] ints, int target) {
        int low = 0;
        int high = ints.length;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (ints[mid]==target&&ints[mid -1]!=target) {
                return  mid;
            }else if (ints[mid] < target) {
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
}
