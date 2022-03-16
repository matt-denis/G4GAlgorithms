package hashing;
import java.util.Set;
import java.util.HashSet;

/**
 * Given an array, find whether it coontains two numbers that sum to a given number.
 */
public class HashingForPair {
    
    public static int sumExists(int arr[], int N, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int e : arr) {
            if (set.contains(e)) return 1;
            set.add(sum - e);  // add the complement to the set
        }
        return 0;
    }
}
