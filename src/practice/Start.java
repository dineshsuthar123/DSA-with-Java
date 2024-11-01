package practice;

import java.util.Scanner;

public class Start {
    public class Node{
        int val;
        Node left;
        Node right;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;

    public void insert(Scanner scanner){
        System.out.println("Enter the root node: ");
        int val = scanner.nextInt();
        root = new Node(val);
        insert(scanner,root);
    }

    public void insert(Scanner scanner, Node root){
        System.out.println("do you want you enter the left of :" + root.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value at the left of : " + root.val);
            int val = scanner.nextInt();
            root.left = new Node(val);
            insert(scanner,root.left);
        }

        System.out.println("do you want you enter the right of :" + root.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value at the right of : " + root.val);
            int val = scanner.nextInt();
            root.right = new Node(val);
            insert(scanner,root.right);
        }
    }

    public void display(){
        display(root,0);
    }

    public void display(Node node ,int level){
        if(node == null){
            return;
        }
        display(node.right, level+1);

        if(level != 0)
        {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|--------->" + node.val);
        }
        else
        {
            System.out.println(node.val);
        }

        display(node.left, level+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Start s = new Start();
        s.insert(scanner);

        s.display();
    }
}
