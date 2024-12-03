package Queue;

import java.util.NoSuchElementException;
import Node.*;


public class QueueImpl<T> implements ADTQueue<T> {
    
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public ADTQueue<T> enqueue(T element) {
        Node<T> oldtail = tail;
        tail = new Node<T>(element, null);
        if (head != null)
            oldtail.setNext(tail);
        else
            head = tail;
        return this;
    }

    @Override
    public QueueImpl<T> dequeue() {
        if(isEmpty())
            throw new java.lang.IllegalStateException();
        else
            head = head.getNext();
        return this;
    } 

    @Override
    public T front() {
        if (isEmpty())
            throw new NoSuchElementException();
        else
            return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

}
