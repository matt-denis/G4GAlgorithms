package hashing;
import java.util.LinkedList;

public class ChainingHashTable {
    private static final int SIZE = 7;
    private final LinkedList<Integer>[] table;
    
    @SuppressWarnings("unchecked")
    public ChainingHashTable() {
        table = (LinkedList<Integer>[]) new LinkedList[SIZE];
    }
        
    private static final int hash(int x) {
        return x % SIZE;
    }


    public void insert(int e) {
        int index = hash(e);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
            table[index].add(e);
        }
        else {
            int listIndex = table[index].indexOf(e);
            if (listIndex == -1) table[index].add(e);
            else table[index].add(e, listIndex);
        }
        
    }
    
    public boolean search(int e) {
        int index = hash(e);
        if (table[index] == null) return false;
        return table[index].contains(e);
    }

    public boolean delete(int e) {
        int index = hash(e);
        if (table[index] == null) return false;
        return table[index].remove((Integer) e);
    }
}
        