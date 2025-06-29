import java.util.Random;
import java.util.Scanner;

public class _1 {
    static int searchcount = 0;
    static int sortcount = 0;

    public static int sequentialSearch(int[] a, int key) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            searchcount++;
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                sortcount++;
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter the number of elements (n > 5000): ");
        int n = s.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000); 
        }

        int rnd = r.nextInt(a.length);
        System.out.println("random number is: " + a[rnd]);

        System.out.print("Enter the key to search: ");
        int key = s.nextInt();

        int index = sequentialSearch(a, key);
        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("Key not found");
        }
        System.out.println("Number of basic operations for searching is: " + searchcount);

        selectionSort(a);
        System.out.println("Sorted numbers are:");
        for (int i = 0; i < 5; i++)
            System.out.println(a[i]);
        System.out.println("Number of basic operations for sorting is: " + sortcount);
    }
}