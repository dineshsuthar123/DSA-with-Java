package introduction;

public class LinearRec {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 7, 9, 12, 24, 35, 36 };
        int target = 17;
        System.out.println(linear(arr, target, 0));
    }

    static boolean linear(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || linear(arr, target, index + 1);
    }
}
