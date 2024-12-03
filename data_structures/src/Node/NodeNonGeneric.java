package Node;

public class NodeNonGeneric {
    
    private NodeNonGeneric next;
    private Object element;

    public NodeNonGeneric(Object element, NodeNonGeneric next) {
        this.element = element;
        this.next = next;
    }

    public NodeNonGeneric getNext() {
        return next;
    }

    public void setNext(NodeNonGeneric next) {
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
