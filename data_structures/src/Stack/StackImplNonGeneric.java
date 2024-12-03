package Stack;

import Node.*;

public class StackImplNonGeneric implements ADTStackNonGeneric {
    
    private NodeNonGeneric top;

    @Override
    public ADTStackNonGeneric push(Object element) {
        top = new NodeNonGeneric(element, top);
        return this;
    }

    @Override
    public StackImplNonGeneric pop() {
        if (isEmpty())
        throw new java.util.NoSuchElementException();
        else {
        top = top.getNext();
        return this;}
        }

    @Override
    public Object top() {
        if (isEmpty())
        throw new java.util.NoSuchElementException();
        else
        return top.getElement();
        }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
}
