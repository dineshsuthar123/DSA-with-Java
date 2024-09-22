package practice;

import java.util.Scanner;

public class solve {
    class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
        
    }
    private Node root;

    public void insert(Scanner scanner){
        System.out.println("Enter the root node : ");
        int val = scanner.nextInt();
        root = new Node(val);
        insert(scanner , root);
    }

    public void insert(Scanner scanner , Node node){
        System.out.println("Do you want to enter to the left of " + node.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to be inserted in the left of " + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            insert(scanner, node.left);
        }

        System.out.println("Do you want to enter to the right of " + node.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to be inserted in the right of " + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            insert(scanner, node.right);
        }
    }


    public void display(){
        display(root,0);
    }

    public void display(Node node , int level){
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
        solve Tree = new solve();

        Tree.insert(scanner);

        System.out.println("The tree structure: ");
        Tree.display();
        }
    }
