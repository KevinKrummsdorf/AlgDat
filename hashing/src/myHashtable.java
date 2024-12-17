//seperate chaining implementation of hashtable

import java.util.*;

public class myHashtable<K, V> {

    private LinkedList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;

    public myHashtable(int capacity){
        bucketArray = new LinkedList<>();
        numBuckets = capacity;
        size = 0;

        for(int i = 0; i < numBuckets; i++){
            bucketArray.add(null);
        }

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
        HashNode<K, V> head = bucketArray.get(index);

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        } 
        return null;
    }

    public void add(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = bucketArray.get(index);
/*
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
*/
        // Erstelle immer einen neuen Knoten und füge ihn zur Liste hinzu
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(index, newNode);

        // Überprüfe die Last der Tabelle und vergrößere sie bei Bedarf
        if ((1.0*size)/numBuckets >= 0.7) {
            LinkedList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new LinkedList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V remove(K key) {
        int bucketIndex = hash(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        while (head != null) {
            if(head.key.equals(key)) {
                size--;
                if (prev != null)
                    prev.next = head.next;
                else
                    bucketArray.set(bucketIndex, head.next);
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
            HashNode<K, V> head = bucketArray.get(i);
            while (head != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
        }
    }

}