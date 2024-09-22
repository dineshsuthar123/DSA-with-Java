package node;

public class node1 {

    private node head;
    private  node tail;
    private int size;
    public node1(){
        this.size  = 0;
    }

    public void insert(int val){
        node no = new node(val);
        no.next = head;
        head = no;
        if( tail == null){
            tail =head ;
        }
        size += 1;
    }

    public void in(int val , int  index){
        if (index == 0) {
            insert(val);
            return;
        }
        if (index == size) {
            last(val);
            return;
        }
        node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        node nod = new node(val, temp.next);
        temp.next = nod;
        size++;
    }

    public int dellast(){
        if(size <= 1){
            return del();
        }
        node sec= get(size -2);
        int val = tail.value;
        tail = sec;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index ==0){
            return del();
        }
        if(index == size -1){
            return dellast();
        }
        node prev = get( index -1);
        int val = prev.next.value;
        
        prev.next =prev.next.next;

        return val;
    }

    public node find(int value){
        node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public node get(int index){
        node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void last(int val){
        if (tail == null) {
            insert(val);
            return;
        }
        node no1 = new node(val);
        tail.next = no1;
        tail = no1;
        size++;
    }

    public int del(){
        int val = head.value;
        head = head.next;
        if(head ==null){
            tail = null;
        }
        size--;
        return val;
    }

    public void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.value +"-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class node {
        private  int value;
        private node next;
        public node (int value){
            this.value = value;
        }
        public node(int value ,node next){
            this.value = value;
            this.next = next;
        }
    }
}
