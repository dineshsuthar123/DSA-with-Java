package introduction;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();

        switch (fruit) {
            case "mango":
                System.out.println("king of fruit");
                break;
            case "apple":
                System.out.println("keeps doctor away");
                break;
            case "banana":
                System.out.println("good fruit");
                break;
            case "orange":
                System.out.println("nice fruit");
                break;
            default:
                System.out.println("Inavild operation");
        }
    }
}
