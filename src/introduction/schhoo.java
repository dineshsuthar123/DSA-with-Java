package introduction;

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        int year = sc.nextInt();
        int income = sc.nextInt();
        int standing_arrears = sc.nextInt();
        float percant = sc.nextFloat();
        float attend = sc.nextFloat();
        if (year >= 2021 && standing_arrears <= 2 && income <= 200000 && (age >= 18 || age <= 21) && percant >= 60
                && attend >= 80) {
            System.out.println("Eligible");
        } else if (year >= 2021 && standing_arrears > 2 && (income >= 200000 || income <= 250000)
                && (age >= 18 || age <= 21) && percant >= 80 && attend >= 90) {
            System.out.println("Partially Eligible");
        } else {
            System.out.println("Not Eligible");
        }
    }
}
