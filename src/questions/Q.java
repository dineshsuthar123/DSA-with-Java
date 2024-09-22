package questions;

public class Q {
    // public static void main(String[] args) {
    //     triangle(10,0);
    // }

    // public static void triangle(int r , int c) {
    //     if(r == 0){
    //         return;
    //     }
    //     if( c < r){
    //         System.out.print("*");
    //         triangle(r, c+1);
    //     }else{
    //         System.out.println();
    //         triangle(r-1, 0);
    //     }
    // }

    // public static void main(String[] args) {
    //     int []arr = {1,2,3,5,5,6,7};
    //     int target = 4;
    //     System.out.println(linear1(arr,target,0));
    // }

    // public static int linear(int []arr,int target , int index) {
    //     if(index == arr.length){
    //         return -1;
    //     }
    //     if(arr[index] == target){
    //         return index;
    //     }else{
    //         return linear(arr, target, index + 1);
    //     }
    // }
    // static ArrayList<Integer> linear1(int []arr,int target , int index) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     if(index == arr.length){
    //         return list;
    //     }
    //     if(arr[index] == target){
    //         list.add(index);
    //     }
    //     ArrayList<Integer> ans = linear1(arr, target, index + 1);
    //     list.addAll(ans);
    //     return list;
    // }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(search(arr, 3, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int m = s + (e-s) / 2;
        if (arr[m] == target) {
            return m;
        }

        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m-1);
            } else {
                return search(arr, target, m+1, e);
            }
        }

        if (target >= arr[m] && target <= arr[e]) {
            return search(arr, target, m+1, e);
        }

        return search(arr, target, s, m-1);
    }
}
