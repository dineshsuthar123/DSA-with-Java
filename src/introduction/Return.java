package introduction;

import java.util.Scanner;

public class Return {
    public static void main(String[] args) {
        sum();
        sum();
    }

    static void sum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter input one:");
        int num1 = in.nextInt();
        System.out.println("Enter input two:");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("sum= " + sum);
    }
}
