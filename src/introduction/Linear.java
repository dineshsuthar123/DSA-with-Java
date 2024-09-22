package introduction;

import java.util.Scanner;

public class Linear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = { 1, 2323, 42, 53, 75, 24, 7, 43, };
        int target = in.nextInt();
        int ans = Linear(nums, target);
        System.out.println(ans);

    }

    static int Linear(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;

    }
}
