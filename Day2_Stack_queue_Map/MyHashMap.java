import java.util.LinkedList;

// Custom HashMap class
public class MyHashMap {

    // size of the hash map
    private static final int SIZE = 1000;
    private LinkedList<Entry>[] map;

    // Inner class to represent key-value pairs
    private static class Entry {
        int key;
        int value;

        // Constructor
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the map
    public MyHashMap() {
        // Initialize the map array with empty linked lists
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to map keys to array indices
    private int hash(int key) {
        return key % SIZE;
    }

    // Method to insert a key-value pair into the map
    public void put(int key, int value) {
        // Calculating the index using the hash function
        int index = hash(key);
        // Get the corresponding bucket
        LinkedList<Entry> bucket = map[index];

        // Check if the key already exists in the bucket
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If key doesn't exist, create a new entry and add it to the bucket
        bucket.add(new Entry(key, value));
    }

    // Method to retrieve the value associated with a key
    public int get(int key) {
        // Calculating the index using the hash function
        int index = hash(key);
        // Get the corresponding bucket
        LinkedList<Entry> bucket = map[index];

        // Searching for the key in the bucket
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }

    // Method to remove a key-value pair from the map
    public void remove(int key) {
        // Calculate the index using the hash function
        int index = hash(key);
        // Get the corresponding bucket
        LinkedList<Entry> bucket = map[index];

        // Searching for the key in the bucket and remove it
        for (Entry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the custom hash map
        MyHashMap hashMap = new MyHashMap();

        // Inserting key-value pairs
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        hashMap.put(3, 30);

        // Retrieving and printing values
        System.out.println("Value for key 1: " + hashMap.get(1));
        System.out.println("Value for key 2: " + hashMap.get(2));
        System.out.println("Value for key 3: " + hashMap.get(3));

        // Removing a key-value pair
        hashMap.remove(2);

        System.out.println("Value for key 2 after removal: " + hashMap.get(2));
    }
}
