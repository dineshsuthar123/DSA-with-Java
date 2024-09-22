package practice;

public class sol1 {
    
    private Node head;
    private Node tail;
    private int size;
    
    public void Solution(){
        this.size = 0;
    }
    
    public class Node{
        private int val;
        private Node next;
        
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public void insert(int val){
            Node node = new Node(val);
            node.next = head;
            head = node;
            if(tail == null){
                tail = head;
            }
            size ++;
        }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
        }
        System.out.print("END");
    }

    public static void main(String[] args) {
        sol1 node = new sol1();
        node.insert(1);
        node.insert(1);
        node.insert(1);
        node.insert(1);
        node.insert(1);
        node.display();
    }
}