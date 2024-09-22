package practice;

import java.util.Scanner;

public class p {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        int top = -1;
        for(int i =0; i< n ; i++){
            String ip = sc.next();
            if(ip.equals("push")){
                top++;
                arr[top]  =sc.nextInt();
            }
            else if (ip.equals("pop")){
                top--;
            }
            else if(ip.equals("print")){
                for(int j = 0; j <=top ;j++){
                    System.out.println(arr[j]);
                }
            }
        }
    }
}
