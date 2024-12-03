package Stack;

import Node.*;
import java.util.NoSuchElementException;

public class StackImpl<T> implements ADTStack<T> {
    
    private Node<T> top = null;

    @Override
    public ADTStack<T> push(T element) {
        top = new Node<T>(element, top);
        return this;
    }

    @Override
    public StackImpl<T> pop() {
        if(isEmpty())
            throw new java.lang.IllegalStateException();
        else
            top = top.getNext();
        return this;
    }

    @Override
    public T top() {
        if (isEmpty())
            throw new NoSuchElementException();
        else
            return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }
    
}
