import java.util.Scanner;

public class _4 {
    static int[][] cost = new int[10][10];
    static int[] indegree = new int[10]; 
    static int n;                       

    static void calculate() {
        for (int i = 0; i < n; i++) {
            indegree[i] = 0;
            for (int j = 0; j < n; j++) {
                indegree[i] += cost[j][i]; 
            }
        }
    }

    static void sourceRemoval() {
        int[] removed = new int[10];
        System.out.print("Topological ordering is: ");
        for (int i = 0; i < n; i++) {
            calculate();
            int j;
            for (j = 0; j < n; j++) {
                if (removed[j] == 0 && indegree[j] == 0) 
                    break;
            }
            if (j == n) { 
                System.out.println("Graph is cyclic, so no solution.");
                return;
            }
            System.out.print(j + " ");
            removed[j] = 1;
            for (int k = 0; k < n; k++) {
                cost[j][k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        n = s.nextInt();
        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = s.nextInt();
            }
        }
        sourceRemoval();
    }
}