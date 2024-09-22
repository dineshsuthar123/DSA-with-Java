package introduction;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 1;
        while (num <= 10) {
            System.out.println(num);
            num++;
        }
    }
}
