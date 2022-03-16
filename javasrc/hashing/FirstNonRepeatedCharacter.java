package hashing;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Find the first non-repeated character in a string
 */
public class FirstNonRepeatedCharacter {

    static char nonrepeatingCharacter(String S)
    {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<Character>();
        int currIdx = 0;
        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (! map.containsKey(c)) {
                map.put(c, currIdx);
                list.add(currIdx++, c);
            }
            else {
                list.set(map.get(c), null);
            }
        }
        int i = 0;
        for ( ; i < list.size() && list.get(i) == null; i++) {}
        return i == list.size() ? '$' : list.get(i);
    }
}