package introduction;

public class treeee {
    public static void main(String[] args) {
        int n = 30;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                if (i % 2 != 0 && i % 3 != 0) {
                    if (n % 2 == 0) {
                        System.out.println(2);
                    }
                    if (n % 3 == 0) {
                        System.out.println(3);
                    }
                    System.out.println(i);
                }
            }
        }

    }
}
