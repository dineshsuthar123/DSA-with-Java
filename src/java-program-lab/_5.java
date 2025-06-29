import java.util.Scanner;

public class _5 {
    static void prim(int cost[][], int n, int source) {
        int[] tvertex = new int[n];
        int a = 0, b = 0, min, mincost = 0, ne = 0;
        tvertex[source] = 1;
        while (ne < n - 1) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (tvertex[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (cost[i][j] < min && tvertex[j] == 0) {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }
            System.out.println("Pipeline from city " + a + " to city " + b + " and the cost " + min + " units");
            tvertex[b] = 1;
            ne++;
            mincost += min;
        }
        System.out.println("Minimum cost of urban water supply networks " + mincost + " units");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of Cities");
        int n = s.nextInt();
        int[][] c = new int[n][n];
        System.out.println("Enter the cost of laying pipelines between the two cities");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = s.nextInt();
                if (c[i][j] == 0)
                    c[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println("Enter the source city");
        int source = s.nextInt();
        prim(c, n, source);
    }
}