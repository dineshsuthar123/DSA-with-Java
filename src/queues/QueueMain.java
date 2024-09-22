package queues;

public class QueueMain{
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(45);
        queue.insert(48);
        queue.insert(42);
        queue.insert(49);

        queue.display();
        System.out.println(queue.remove());

        queue.display();

        
    }

    static  class CustomQueue {
        protected int[] data;
        private static final int DEFAULT_SIZE = 10;
    
        private int end = 0;
    
        public CustomQueue() {
            this(DEFAULT_SIZE);
        }
    
        public CustomQueue(int size) {
            this.data = new int[size];
        }
        private boolean isFull() {
            return end == data.length - 1;
        }
    
        private boolean isEmpty() {
            return end == -1;
        }
    
        public boolean insert(int item){
            if(isFull()){
                return false;
            }
            data[end++] = item;
            return true;
        }
        public int remove() throws Exception{
            if(isEmpty()){
                throw new Exception("Queue is empty");
            }
            int removed = data[0];
    
            for (int i = 1; i < end; i++) {
                data[i-1] = data[i];
            }
            end--;
            return removed;
        }
    
        public int front() throws  Exception{
            if(isEmpty()){
                throw new Exception("Queue is empty");
            }
            return data[0];
        }
    
        public void display(){
            for (int i = 0; i < end; i++) {
                System.out.print(data[i] + " <- ");
            }
            System.out.println("END");
        }
    }
}


