package Stack;

import java.util.NoSuchElementException;

public class BoundedStack<T> implements ADTStack<T> {
    
    private Object[] elements;
    private int topIndex = -1;

    public BoundedStack(int capacity) {
        elements = new Object[capacity];
    }

    public BoundedStack<T> push(T item) {
        if (topIndex == elements.length-1) {
        throw new IllegalStateException("Cannot add to full stack"); }
        topIndex++;
        elements[topIndex] = item;
        return this;
    }

    public BoundedStack<T> pop() {
        if (topIndex == -1) {
        throw new NoSuchElementException("Cannot remove from empty stack");}
        Object item = elements[topIndex];
        elements[topIndex] = null;
        topIndex--;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (topIndex == -1) {
        throw new NoSuchElementException("Cannot return front from empty stack");}
        return (T) elements[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }
    
}
