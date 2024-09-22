package node;

public class D {
    node head;


    public void insertf(int val){
        node no = new node(val);
        no.next = head;
        no.prev = null;
        if (head != null) {
            head.prev = no;            
        }
        head = no;
    }
    public  void display(){
        node temp = head;
        node last = null;
        while(temp != null){
            System.out.print(temp.value +"-> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        while(last != null){
            System.out.print(last.value +"-> ");
            last = last.prev;
        }
        System.out.println("START");

    }

    
    class node {
        private  int value;
        private node next;
        private node prev;
        public node(int value, node next, node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public node (int value){
            this.value = value;
        }
        public node(int value ,node next){
            this.value = value;
            this.next = next;
        }
    }
}
