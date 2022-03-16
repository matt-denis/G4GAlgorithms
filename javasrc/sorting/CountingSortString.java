package sorting;

public class CountingSortString {

    public static String countSort(String arr)
    {
        int lo = (int) 'a';
        int hi = (int) 'z';
        int offset = lo;
        int n = arr.length();
        
        var count = new int[hi - lo + 1];
        for (int k = 0; k < n; k++) {
            count[arr.charAt(k) - offset]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        var output = new char[n];
        
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.charAt(i) - offset] - 1] = arr.charAt(i);
            count[arr.charAt(i) - offset]--;
        }
        arr = new String(output);
        return arr;
    }
}