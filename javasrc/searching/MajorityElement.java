package searching;

/*
Apply the pigeonhole principle. If there are more elements than half of the array
length, then there are at least two elements that are next to each other.
Incidentally, we can show that there is only a unique majority element.

--> xoxoxoxoxoxoxoxoxoxoxo

We can place all n / 2 elements on x and the remaining one goes on an o. That means
that after the pair, the count will not goelow 1. If we move 3 together, then again
the count will not go below 1, as it will reach at least 3 after going over the triple, 
and we have only but two places next to each other where the majority element is not present.
*/

public class MajorityElement {
    
    static int majorityElement(int a[], int size)
    {
        int cand = findCandidate(a, size);
        return isMajority(a, cand) ? cand : -1;
        
    }
    
    private static int findCandidate(int[] a, int size) {
        int majIdx = 0, count = 1;
        for (int i = 1; i < size; i++) {
            if (a[i] == a[majIdx]) count++;
            else count--;
            if (count == 0) {
                majIdx = i;
                count = 1;
            }
        }
        return a[majIdx];
    }
    
    private static boolean isMajority(int[] arr, int e) {
        int count = 0;
        for (int x : arr) {
            if (x == e) count++;
        }
        return count > arr.length / 2;
    }
}
