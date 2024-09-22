package introduction;

public class Binary {
    public static void main(String[] args) {
        int[] arr = { -12, -5, -1, 2, 3, 5, 9, 10, 13, 15, 17, 18, 21 };
        int target = 10;
        int ans = BinarySearch(arr, target);
        System.out.println(ans);
    }

    static int BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
