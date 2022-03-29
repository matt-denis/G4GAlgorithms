/**
 * Longest increasing subsequence.
 * Given an integer array of length n, find the length of the longest subsequence
 * which is also increasing. If no increasing subsequence exists, we consider single
 * elements as trvial 1-element subsequences of length 1.
 */

package dynamic;

public class LIS {


    static int lis(int[] seq) {
        final int n = seq.length;
        int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        return arrayMax(lis);
    }

    private static int arrayMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    static int lisOptimized(int[] seq) {
        final int n =  seq.length;
        final int[] tail = new int[n];
        int len = 1;
        tail[0] = seq[0];
        for (int i = 1; i < n; i++) {
            if (seq[i] > tail[len - 1]) {
                tail[len++] = seq[i];
            }
            else {
                int idx = ceil(tail, 0, len - 1, seq[i]);
                tail[idx] = seq[i];
            }
        }
        return len;
    }


    private static int ceil(int[] arr, int lo, int hi, int e) {
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < e) lo = mid + 1;
            else if (arr[mid] > e) hi = mid;
            else return mid;
        }
        return hi;
    }

    // G4G implementation - for some reason it's faster

    static int ceilIdx(int tail[], int l, int r, int key) 
        { 
            while (r > l) {         
                int m = l + (r - l) / 2; 
                if (tail[m] >= key) 
                    r = m; 
                else
                    l = m+1; 
            } 
      
            return r; 
        } 
  
    static int lisG4G(int arr[], int n) 
    { 
     
  
        int[] tail = new int[n]; 
        int len =1; 
  
        tail[0] = arr[0]; 
        
        for (int i = 1; i < n; i++) {
            
            if(arr[i] > tail[len - 1])
            {
                tail[len] = arr[i];
                len++;
            }
            else{
                int c = ceilIdx(tail, 0, len - 1, arr[i]);
                
                tail[c] = arr[i];
            }
        } 
  
        return len; 
    } 

}