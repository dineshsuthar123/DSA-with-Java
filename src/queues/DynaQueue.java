package queues;

public class DynaQueue extends CircularQueue{
    @Override
    public boolean insert(int item) {
        if(this.isFull()){
            int [] temp =new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length]; 
            }
            front = 0;
            end = data.length;
            data = temp;
        }

        return super.insert(item);
    }
    public DynaQueue(){
        super();
    }
    public DynaQueue(int size) {
        super(size);
    }

    private boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
