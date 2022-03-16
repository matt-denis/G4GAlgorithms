package hashing;
import java.util.Set;
import java.util.HashSet;

public class CountDistinctElements {
    
    public static int count(int[] a) {
        if (a.length == 0) return 0;
        Set<Integer> set = new HashSet<>(a.length / 2); // 0.5 prob that half of te elements are unique
        for (int e : a) {
            set.add(e);  // does not insert if present
        }
        return set.size();
    }
}