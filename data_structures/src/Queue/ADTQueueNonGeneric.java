package Queue;

public interface ADTQueueNonGeneric {

    public ADTQueueNonGeneric enqueue(Object element);

    public ADTQueueNonGeneric dequeue();

    public Object front();
    
    public boolean isEmpty();
    
}
