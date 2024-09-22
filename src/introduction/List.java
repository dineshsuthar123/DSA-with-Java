package introduction;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 4, 8, 6 };
        int target = 4;
        System.out.println(AllList(arr, target, 0));
    }

    static ArrayList<Integer> RList(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return RList(arr, target, index + 1, list);
    }

    static ArrayList<Integer> AllList(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> All = AllList(arr, target, index + 1);
        list.addAll(All);
        return list;
    }
}
