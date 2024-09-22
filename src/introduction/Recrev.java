package introduction;

public class Recrev {
    public static void main(String[] args) {
        Rev(1234);
        System.out.println(sum);
    }

    static int sum = 0;

    static void Rev(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        Rev(n / 10);
    }
}
