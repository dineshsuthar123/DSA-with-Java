package node;

import java.util.*;

public class D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node2 list = new node2();
        int n = sc.nextInt();
        System.out.println("Enter number of elements:");
        for(int i = 0; i < n; i++){
            int ele = sc.nextInt();
            list.insert(ele);
        }
        list.display();
    }
}
