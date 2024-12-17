//direct chaining implementation of hashtable

public class myHashtableChaining<K,V> {

    private HashNode<K,V>[] bucketArray;
    private int numBuckets;
    private int size;

    public myHashtableChaining(int capacity){
        bucketArray = new HashNode[capacity];
        numBuckets = capacity;
        size = 0;

        for(int i = 0; i < numBuckets; i++)
            bucketArray[i] = null;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int hash(K key){
        int hashValue = key.hashCode() % numBuckets;
        if(hashValue < 0){
            hashValue += numBuckets;
        }
        return hashValue;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = bucketArray[index];

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        } 
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray[bucketIndex];
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public V remove(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray[bucketIndex];
        HashNode<K, V> prev = null;

        while (head != null) {
            if(head.key.equals(key)) {
                size--;
                if (prev != null)
                    prev.next = head.next;
                else
                    bucketArray[bucketIndex] = head.next;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null; 
    }
        
    public void printTable() {
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("\nBucket " + i + ": ");
            HashNode<K, V> head = bucketArray[i];
            while (head != null) {
                System.out.print("[Key: "+head.key + " : Value: "+head.value+"]");
                head = head.next;
            }
        }
    }
}