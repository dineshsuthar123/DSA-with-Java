package node;

public class node2 {
    node head;
    node tail;
    int size;
    
    public node2() {
        this.size = 0;
    }

    

    public void insert(int val){
        node nod = new node(val);
        nod.next  =head;
        head = nod;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void display(){
        node temp = head;
        while (temp != null) { 
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class node{
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
        public node(int val, node next) {
            this.val = val;
            this.next = next;
        }
        }
    }
