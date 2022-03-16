package hashing;

public class OpenAddressingHashTable {
    
    private int[] table;
    private int capacity;
    private int size;
    private int loadFactor = (size / capacity);

    public OpenAddressingHashTable(int capacity) {
        table = new int[capacity];
        this.capacity = capacity;
    }

    private int hash(int key) {
        return key % capacity;
    }

    private void updateLoadFactor() {loadFactor = size / capacity; }

    private void resize(int cap) {
        var tmp = new int[cap];
        for (int i = 0; i < size; i++) {
            tmp[i] = table[i];
            table = tmp;
            capacity = cap;
            updateLoadFactor();
        }
    }
    /**
     * 
     * @param key key to search
     * @return index where the key was found or an available slot to insert the key
     */
    private int getIndex(int key) {
        int probe = hash(key);
        if (table[probe] == key) return probe;
        int offset = 1;
        int start = probe;
        int firstDeletion = -1;
        do {
            offset++;
            probe = (probe + offset) / capacity;
            if (firstDeletion == -1 && table[probe] == -2) firstDeletion = probe;

        } while (probe != start && table[probe] != key && table[probe] != -1);

        return probe == start ? firstDeletion : probe; // in linear probing firstDeletion != -1
    }

    private int getInsertionIndex(int key) {
        int idx = getIndex(key);
        if (idx == -1 || table[idx] == key) return -1;
        return idx;
    
    }

    private int getDeletionIndex(int key) {
        int idx = getIndex(key);
        // we want to retur true in the caller if it was deleted => -2
        if (idx == -1 || table[idx] == -1) return -1;
        return idx;
    }


    public int loadFactor() { return loadFactor; }

    public boolean insert(int key) {
        if (key < 0) throw new IllegalArgumentException("key must be > 0");
        if (loadFactor > 0.5) resize(capacity * 2);
        int idx = getInsertionIndex(key);
        if(idx == -1) return false;
        table[idx] = key;
        size++;
        updateLoadFactor();
        return true;
    }

    public boolean erase(int key) {
        int idx = getDeletionIndex(key);
        if (idx == -1) return false; // key not present
        table[idx] = -2;
        return false; // we don't decrease the size as -2 will not stop searches
    }
    
    public boolean search(int key) {
        int idx = getIndex(key);
        if (idx == -1 || table[idx] < 0) return false;
        return true;
    }
}