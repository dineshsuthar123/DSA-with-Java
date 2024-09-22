package practice;

import java.util.Scanner;

public class BT {
    public static class Node{
        
        int value;
        Node left;
        Node right;
        
        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;

    public void insert(Scanner scanner) {
        System.out.println("Enter the value for root node:");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(scanner , root);
    }
    private void insert(Scanner scanner , Node node){
        System.out.println("Do you want enter a value to the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to be inserted in the left of " + node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);
            insert(scanner,node.left);
        }

        System.out.println("Do you want enter a value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to be inserted in the right of " + node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);
            insert(scanner,node.right);
        }
    }
    public void Display(){
        Display(root,0);
    }
    private void Display(Node node , int level){
        if(node == null){
            return;
        }
        Display(node.right, level + 1);

    if (level != 0) {
      for (int i = 0; i < level - 1; i++) {
        System.out.print("|\t\t");
      }
      System.out.println("|------->" + node.value);
    } else {
      System.out.println(node.value);
    }
    Display(node.left, level + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BT bt = new BT();

        bt.insert(scanner);

        bt.Display();
    }
}
