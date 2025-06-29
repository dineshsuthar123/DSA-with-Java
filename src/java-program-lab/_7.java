import java.util.Scanner;

public class _7 {
    static void kruskal(int cost[][], int n) {
        int[] par = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = -1;

        int a = 0, b = 0, u = 0, v = 0, min, mincost = 0, ne = 0;

        while (ne < n - 1) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }

            while (par[u] != -1)
                u = par[u];
            while (par[v] != -1)
                v = par[v];

            if (u != v) {
                System.out.println("Cost of Laying road from town " + a + " to town " + b + " is " + min + " Lakhs");
                mincost += min;
                if (u < v)
                    par[v] = u;
                else
                    par[u] = v;
                ne++;
            }
            cost[a][b] = cost[b][a] = Integer.MAX_VALUE;
        }
        System.out.println("Cost of Laying entire Road Network =" + mincost + " Lakhs");
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of towns");
        n = s.nextInt();
        int[][] c = new int[n][n];
        System.out.println("Enter the cost of laying roads between two towns in lakhs");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = s.nextInt();
                if (c[i][j] == 0)
                    c[i][j] = Integer.MAX_VALUE;
            }
        }
        kruskal(c, n);
    }
}