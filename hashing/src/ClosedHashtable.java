public class ClosedHashtable <K,V> {

    protected int[] target;
    private HashElement<K,V>[] table;
    protected int size;
    protected int capacity;
    static final int EMPTY= 0;
    static final int OCCUPIED= 1;
    static final int DELETED= 2;

    public int size() { return size; }
    public int getCapacity() { return capacity; }
    public boolean isEmpty() { return size() != 0; }

    @SuppressWarnings("unchecked")
    public ClosedHashtable(int capacity){
        this.capacity= capacity;
        table = (HashElement<K,V>[]) new HashElement[capacity];
        target= new int[capacity];
        for(int i=0; i<capacity; i++){
            target[i]= EMPTY;
            table[i]= null;        
        }
        size = 0;
    }

    private HashElement<K, V> getTableEntry(int index) {
        return table[index];
    }

    public int hash(K key){
        int hashValue = key.hashCode () % capacity;
        if (hashValue < 0){
            hashValue = hashValue + capacity;
        }
        return hashValue;
    }

    public int s (int j, Object key) {
        return j;
    }

    public void add(K key, V value) {
        if (size == capacity) return;
        int k = hash(key);
        int i = k;
        int j = 0;
        while (target[i] == OCCUPIED) {
        i = (k + s(j, key)) % capacity;
        j++;
        }
        table[i] = new HashElement<K, V>(key, value);
        target[i] = OCCUPIED;
        size++;
    }

    public int searchForKey (K key) {
        int k = hash(key);
        int i = k;
        int j = 0;
        while (target[i] != EMPTY && ! (target[i] == OCCUPIED && key.equals(table[i].key)) && j <= capacity) {
            i = (k + s(j++, key)) % capacity; }
            if (j <= capacity && target[i] == OCCUPIED)
                return i;
            else
                return -1;
    }

    public V find(K key) {
        int i = searchForKey(key);
        if (i != -1 && table[i] != null)
            return table[i].value;
        else
            return null;
    }

    public V remove(K key) {
        int i = searchForKey(key);
        V value = table[i].value;
        if (i != -1) {
            target[i] = DELETED;
            table[i] = null;
            size--;
            return value;
        } else
            return null;
    }

    public void printTable() {

        for (int i = 0; i < getCapacity(); i++) {
            switch (target[i]) {
            case EMPTY:
            System.out.print("[ ]");
            break;
            case OCCUPIED:
            System.out.print("(");
            System.out.print(getTableEntry(i).key);
            System.out.print(")");
            break;
            case DELETED:
            System.out.print("{");
            System.out.print("}");
            break;
            }
            System.out.print(" ");
            }
            System.out.println ();
    }
}

