/*Tumulak, Rachel Monique K.
 *CS203
 *2CSA
 *Lab Exercise 7 
 */

public class Queue<T>{
    private int maxQSize = 100;
    private int front = -1, rear = -1;
    private Object[] que;
    
    public Queue(){
        que = new Object[maxQSize];
    }
    public Queue(int n){
        if (n>0) maxQSize = n;
        que = new Object[maxQSize];
    }
    public void clear(){
        front = rear = -1;
    }
    public boolean isEmpty(){
        return (front == -1);
    }
    public boolean isFull(){
        return ((rear+1) % maxQSize == front);
    }
    public int enqueue(T el){
        if (isFull()) return -999;
        if (isEmpty()) front = 0;
        rear = (rear + 1) % maxQSize;
        que[rear] = el;
        return 1;
    }
    public T dequeue(){
        if (isEmpty()) return null;
        T el = (T) que[front];
        if (front == rear) clear();
        else front = (front + 1) % maxQSize;
        return el;
    }
    public T peek(){
        if (isEmpty()) return (T)"Queue is empty";
        else return (T)que[front];
    }
}
