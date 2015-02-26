
public class Queue {
    protected final int CAP = 1000;
    protected int origCap;
    protected Object[] queue;
    protected int front;
    protected int rear;
    protected int numOfElements;
    
    public Queue(){
        queue = new Object[CAP];
        front = 0;
        rear = -1;
    }
    
    public void enQueue(Object element){
        if(numOfElements == queue.length){
            enlarge();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        numOfElements = numOfElements + 1;
    }
    
    public Object deQueue(){
        Object toReturn = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        numOfElements = numOfElements - 1;
        return toReturn;
    }
    
    public void enlarge(){
        Object[] larger = new Object[queue.length + origCap];
        int currSmaller = front;
        for(int currLarger = 0; currLarger < numOfElements; currLarger++){
            larger[currLarger] = queue[currSmaller];
            currSmaller = (currSmaller + 1) % queue.length;
        }
    }
    
    public boolean isEmpty(){
        if(numOfElements == 0){
            return true;
        }
        else return false;
    }
}
