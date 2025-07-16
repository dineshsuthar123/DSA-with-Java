package codeForces;

import java.util.*;

public class KarSalesman {
    static class Car implements Comparable<Car> {
        int quality;
        int cost;
        Car(int quality, int cost) {
            this.quality = quality;
            this.cost = cost;
        }
        @Override
        public int compareTo(Car other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int quality = scanner.nextInt();
            int cost = scanner.nextInt();
            cars.add(new Car(quality, cost));
        }

        Collections.sort(cars);

        long totalCost = 0;
        int carsBought = 0;

        for (int i = 0; i < n && carsBought < k; i++) {
            totalCost += Math.min(cars.get(i).cost, cars.get(i).quality);
            carsBought++;
        }

        System.out.println(totalCost);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                solve(scanner);
            }
        }
    }
}
// 3
// 5 3
// 3 2
// 1 1
// 3 3
// 4 5
// 2 4
// 3 2
// 1 1
// 2 2
// 3 3
// 1 1
// 5 5
