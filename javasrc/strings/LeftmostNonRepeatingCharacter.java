package strings;

public class LeftmostNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(findSinglePass("aabbccd"));
    }

    public static final int CHAR = 256;

    public static int find(String s) {
        int[] table = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i)] == 1) return i;
        }
        return -1;
    
    }

    public static int findSinglePass(String s) {
        char[] links = new char[CHAR];
        int[] table = new int[CHAR];
        char leftmost = '\0';  // flag to mark the end of the link chain
        int leftmostIdx = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (table[c] == 0) {
                links[c] = leftmost;
                leftmost = c;
                table[c] = i + 1;  // use 1-based indices
                leftmostIdx = i;  // 0-based
            }
            else {
                if (c == leftmost) {
                    // assumes \0 is not present in s, otherwise start with while and move second if first
                    do {  
                        leftmost = links[leftmost];
                        // note that whenever leftmost gets back to '\0', since '\0' never
                        // appears in a string, the value of leftmostIdx is updated to 0 - 1 = -1
                        leftmostIdx = table[leftmost] - 1;  // re-convert to 0-based
                    } while (leftmost != '\0' && table[leftmost] == -1);
                }
                // if statement before assigning to -1 avoids re-writing all the time
                if (table[c] > 0) table[c] = -1; // flag to mean has been seen more than once
            }
        }
        return leftmostIdx;
    }

    public static int nonRep(String s) {
        int[] firstIndices = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndices[c] == 0) {
                firstIndices[c] = i + 1; // 1-based
            }
            else {
                firstIndices[c] = -1;
            }
        }
        int leftmost = Integer.MAX_VALUE;
        for (int idx : firstIndices) {
            if (idx > 0) leftmost = Math.min(leftmost, idx);
        }
        return leftmost == Integer.MAX_VALUE ? -1 : leftmost - 1;
    }

}