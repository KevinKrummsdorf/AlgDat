package Queue;

public interface ADTQueue <T> {

    public ADTQueue<T> enqueue(T element);

    public ADTQueue<T> dequeue();

    public T front();
    
    public boolean isEmpty();
    
}
