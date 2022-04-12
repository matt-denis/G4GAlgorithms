package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class LeftmostRepeatingCharacter {
    private static final int CHAR = 256;

    /* Strategy 1*/
    static int find(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] charTable = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1-based index since array is initialized to 0
            if (!map.containsKey(c)) map.put(c, i + 1);  // has char been seen before
            // else if char seen but not repeated yet
            else if (charTable[c] == 0) charTable[c] = map.get(c); // record 1-based index of first occurrence
        }
        int leftmostIdx = findMinIndex(charTable);
        return leftmostIdx;
        
    }
    private static int findMinIndex(int[] a) {
        int min = 0; // min 1-based index
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && (min == 0 || a[i] < min)) min = a[i];
            if (min == 1) break; // optimization: nothing on the left if index = 1
        }
        return min - 1; // reconverts to 0-based and returns -1 if no repeated elements
    }

    /* Strategy 2*/
    static int leftMost(String str) {
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int fi = fIndex[str.charAt(i)];
            if (fi == -1)
                fIndex[str.charAt(i)] = i;
            else
                res = Math.min(res, fi);
        }    
    
        return (res == Integer.MAX_VALUE)? -1 : res;
    } 

    /* Strategy 3*/
    static int leftMostVisited(String str) 
    {
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for(int i = str.length() - 1; i >= 0; i--){
            if (visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)]=true;
        }
    
        return res;
    }
}