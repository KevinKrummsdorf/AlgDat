public class LinearHashtable<K,V> {

    private int size;
    private K[] keys;
    private V[] values;
    private boolean[] isDeleted;
        
    public LinearHashtable(int size) {
        this.size = size;
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];
        isDeleted = new boolean[size];
    }
        
    public int hash(K key){
        int hashValue = key.hashCode() % size;
        if(hashValue < 0){
            hashValue += size;
        }
        return hashValue;
    }
        
    public void add(K key, V value) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % size; //lineares sondieren
        }
        keys[index] = key;
        values[index] = value;
        isDeleted[index] = false;
    }
        
    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % size; //lineares sondieren
        }
        if (keys[index] == null) {
            return null;
        } else {
            return values[index];
         }
    }
        
    public void remove(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % size; //lineares sondieren
        }
        if (keys[index] != null) {
            isDeleted[index] = true;
        }
    }
        
    public V find(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % size; //lineares sondieren
        }
        if (keys[index] == null) {
            return null;
        } else {
            return values[index];
        }
    }
        
    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index: " + i + " Key: " + keys[i] + " Value: " + values[i]);
        }
    }
        
}
        
    

