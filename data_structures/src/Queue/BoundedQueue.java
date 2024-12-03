package Queue;

import java.util.NoSuchElementException;

public class BoundedQueue<T> implements ADTQueue<T> {

    private Object[] array;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    
    public BoundedQueue(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public BoundedQueue<T> enqueue(T item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
        return this;
    }

    public BoundedQueue<T> dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Object item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T front() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot return front from empty queue");
        }
        return (T) array[head];
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        } 
}
