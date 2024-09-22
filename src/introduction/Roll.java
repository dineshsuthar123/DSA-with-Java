package introduction;

import java.util.Scanner;

public class Roll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("please enter your input number  ");
        int rolno = input.nextInt();
        System.out.println("your roll number is " + rolno);
    }
}
