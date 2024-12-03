package Queue;

import java.util.NoSuchElementException;
import Node.*;

public class QueueImpNonGeneric implements ADTQueueNonGeneric {

    private NodeNonGeneric head = null;
    private NodeNonGeneric tail = null;

    public QueueImpNonGeneric enqueue(Object element) {
        NodeNonGeneric oldtail = tail;
        tail = new NodeNonGeneric(element, null);
        if (head != null)
            oldtail.setNext(tail);
        else
            head = tail;
        return this;
    }

    @Override
    public QueueImpNonGeneric dequeue() {
        if(isEmpty())
            throw new java.lang.IllegalStateException();
        else
            head = head.getNext();
        return this;
    }

    public Object front() {
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
