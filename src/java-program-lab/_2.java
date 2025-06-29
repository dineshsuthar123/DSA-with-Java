import java.util.Random;
import java.util.Scanner;

public class _2 {
    static int count = 0;

    static int partition(int a[], int l, int r) {

        int pivot = a[l], temp, i = l, j = r + 1;
        do {

            do {
                i++;
                count++;
            } while (i < r && a[i] <= pivot);

            do {
                j--;
                count++;
            } while (j > l && a[j] >= pivot);

            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        } while (i < j);

        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        temp = a[l];
        a[l] = a[j];
        a[j] = temp;

        return j;
    }

    static void quicksort(int a[], int l, int r) {
        int s;
        if (l < r) {
            s = partition(a, l, r);
            quicksort(a, l, s - 1);
            quicksort(a, s + 1, r);
        }
    }

    public static void main(String args[]) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of elements");
        n = s.nextInt();
        int a[] = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
        }

        quicksort(a, 0, n - 1);

        System.out.println("\n\nSorted numbers are");
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");

        System.out.println("\n\nBest Case: " + (int) (n * Math.log(n) / Math.log(2)));
        System.out.println("\nNo. of basic operations: " + count);
        System.out.println("\nWorst Case: " + n * n);
    }
}