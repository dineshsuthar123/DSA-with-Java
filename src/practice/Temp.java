package practice;

import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int arr[] = new int[n+1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            arr[n+1] = -1;
            int ans[] = new int[n];
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(arr)
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(ans[i]);
            }
        }
    }
}
