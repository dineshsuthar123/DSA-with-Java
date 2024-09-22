package introduction;

public class BinaryRec {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 6, 9, 7, 13, 74 };
        int target = 74;
        System.out.println(search(arr, target, 0, arr.length));
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (target < arr[m]) {
            return search(arr, target, s, m - 1);
        }
        return search(arr, target, m + 1, e);
    }

    static int RBS(int[] arr, int target, int s, int e) {
        if (s >= e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return RBS(arr, target, s, m - 1);
            } else {
                return RBS(arr, target, m + 1, e);
            }
        }
        if (target >= arr[m] && target <= arr[e]) {
            return RBS(arr, target, m + 1, e);
        } else {
            return RBS(arr, target, s, m - 1);
        }
    }
}
