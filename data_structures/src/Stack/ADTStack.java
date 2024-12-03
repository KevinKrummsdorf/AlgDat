package Stack;

public interface ADTStack <T> {

    public ADTStack<T> push(T element);

    public ADTStack<T> pop();

    public T top();
    
    public boolean isEmpty();
    
}