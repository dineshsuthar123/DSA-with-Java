package introduction;

import java.util.Scanner;

public class Switch2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int empID = in.nextInt();
            String department = in.next();

            switch (empID) {
                case 1 -> System.out.println("dinesh ");
                case 2 -> System.out.println("sunil");
                case 3 -> {
                    System.out.println("emp NO 3");
                    switch (department) {
                        case "IT" -> System.out.println("IT deoartment");
                        case "management" -> System.out.println("management department");
                        default -> System.out.println("department not found");
                    }

                }
                default -> System.out.println("empID not found");

            }
        }
    }
}
