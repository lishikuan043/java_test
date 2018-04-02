package job;


public class BinarySearchDemo1 {


    public static void main(String[] args) {
        int[] ints = {1,2,3,5,6,7,9};
        int target = 3;
        System.out.println(lowbinarySearch(ints,target));
    }

    private static int lowbinarySearch(int[] ints, int target) {
        int low = 0;
        int high = ints.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (ints[mid] == target) {
                return mid;
            }else if (ints[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
