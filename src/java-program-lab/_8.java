import java.util.Scanner;

public class _8 {
    static int min(int m, int n) {
        return (m < n) ? m : n;
    }

    static void dijkstra(int cost[][], int source, int n) {
        int[] tvertex = new int[n];
        int[] dist = new int[n];
        int min, u = 0, v, i, j;

        System.arraycopy(cost[source], 0, dist, 0, n);
        tvertex[source] = 1;
        dist[source] = 0;

        for (i = 0; i < n - 1; i++) {
            min = Integer.MAX_VALUE;
            for (j = 0; j < n; j++) {
                if (tvertex[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            tvertex[u] = 1;
            for (v = 0; v < n; v++) {
                if (tvertex[v] == 0 && cost[u][v] != Integer.MAX_VALUE) {
                    dist[v] = min(dist[v], dist[u] + cost[u][v]);
                }
            }
        }

        System.out.println("The shortest travel time:");
        for (v = 0; v < n; v++)
            System.out.println("From " + source + " city to " + v + " city is " + dist[v]);
    }

    public static void main(String[] args) {
        int source, n;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of cities:");
        n = s.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter the travel time in hours between every two cities:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = s.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println("Enter the source city:");
        source = s.nextInt();

        dijkstra(cost, source, n);
    }
}