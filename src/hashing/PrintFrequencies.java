package hashing;
import java.util.Map;
import java.util.HashMap;

/**
 * print frequencies of occurrence of each number in array
 */
public class PrintFrequencies {

    public static void print(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : a) {
            if (!map.containsKey(e)) map.put(e, 1);
            else map.put(e, (int)map.get(e) + 1);
        }
        System.out.println("Item\tFrequency\n");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%d\t%d%n", entry.getKey(), entry.getValue());
        }
    }
}