import java.util.Scanner;

public class _12 {
    static int a[][], n, source;

    static void path(int succ[]) {
        System.out.print(source + "->");
        for (int j = succ[source]; j != 0; j = succ[j])
            System.out.print(j + "->");
        System.out.println(source);
    }

    static void ckt(int st, int succ[], int visited) {
        int[] temp = new int[n];
        if (visited == n && a[st][source] == 1) {
            path(succ);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (a[st][i] == 1 && succ[i] == 0) {
                succ[st] = i;
                System.arraycopy(succ, 0, temp, 0, n);
                ckt(i, temp, visited + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of delivery locations in a city/vertices");
        n = s.nextInt();
        int[] succ = new int[n];
        a = new int[n][n];
        System.out.println("Enter the roads between delivery locations/adjacency matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }
        System.out.println("Routes for delivery vehicle/Hamiltonian circuits");
        ckt(source = 0, succ, 1);
    }
}