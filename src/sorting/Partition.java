package sorting;

public class Partition {

    public static void main(String[] args) {
        // var a = new int[] {10, 80, 30, 90, 40, 50, 70};
        // var b = new int[] {70, 60, 80, 40, 30};
        // var c = new int[] {30, 40, 20, 50, 80};
        // partition(a, 0, a.length - 1, a.length - 1);
        // partition(b, 0, b.length - 1, b.length - 1);
        // partition(c, 0, c.length - 1, c.length - 1);
        // var d = new int[] {10, 80, 30, 90, 70, 40, 50};
        // var e = new int[] {10, 80, 70, 90, 30, 40, 50};
        // partition(d, 0, d.length - 1, 4);
        // partition(e, 0, e.length - 1, 2);
        // display(a);
        // display(b);
        // display(c);
        // display(d);
        // display(e);

        int[] arr = new int[] {5, 3, 8, 4, 2, 7, 1, 10};
        var arrcp = arr.clone();
        int hp = hoarePartition(arrcp, 0, arrcp.length - 1);
        display(arrcp);
        display(arr);
        System.out.println(hp);
    }
    
    /* UNSTABLE */

    // G4G implementation
    public static int hoarePartition(int[] arr, int lo, int hi) {
        int i = lo - 1, j = hi + 1;
        int key = arr[lo];
        while (true) {
            do {
                i++;
            } while (arr[i] < key);
            do {
                j--;
            } while (arr[j] > key);
            if (j <= i) return j;
            swap(arr, i, j);
        }
    }


    public static int partition(int[] arr, int lo, int hi, int pidx) {
        int key = arr[pidx];
        int cursor = 0;
        for (int k = lo; k <= hi; k++) {
            if (arr[k] < key) {
                if (cursor == pidx) pidx = k;  // update final position of pivot if it moved to somewhere else
                swap(arr, cursor++, k); 
            }
        }
        swap(arr, cursor, pidx);  
        /* there are at most n - 1 keys less than key
        if this is the case, for each comparison we increase cursor by one, so 
        cursor is at most n - 1
        now, to the right of key we have keys larger than or equal to key */
        return cursor;
    }

    public static int partitionRight(int[] arr, int lo, int hi, int pidx) {
        int key = arr[pidx];
        int cursor = hi;
        for (int k = hi; k >= lo; k--) {
            if (arr[k] > key) {
                if (cursor == pidx) pidx = k;
                swap(arr, cursor--, k);
            }
        }
        swap(arr, cursor, pidx);
        /* similarly cursor decreases at most by n - 1 becoming 0, as there are 
        at most n - 1 elements strictly larger than key.
        To the left of the key we have keys smaller than or equal to key */
        return cursor;
    }

    public int partitionAtIndex(int[] arr, int lo, int hi, int pidx) {
        swap(arr, pidx, hi);
        return lomutoPartition(arr, lo, hi);
    }

    public static int lomutoPartition(int[] arr, int lo, int hi) {
        int key = arr[hi];
        int cursor = 0;
        for (int j = 0; j <= hi - 1; j++) {
            if (arr[j] < key) swap(arr, cursor++, j);
        }
        swap(arr, cursor, hi);
        return cursor;
    }

    /* STABLE */

    public static int partitionRightNaive(int[] arr, int pidx) {
        int key = arr[pidx];
        int n = arr.length;
        int cursor = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (cursor == pidx) pidx--; // update position of pivot (== key)
            if (arr[k] > key) {
                if (cursor == pidx) pidx--; // update position of pivot (== key)
                shiftRight(arr, k, cursor--);
            } // by induction k will always be at or to the left of cursor
        }
        int rightmost = cursor; // by induction pidx will now be at or to the left of cursor
        for (int i = cursor; i >= pidx; i--) {  // to preserve stability
            if (arr[i] > arr[rightmost]) shiftRight(arr, i, rightmost--); // elements from cursor to 0 are at most as large as arr[pidx]
        } 
        return cursor;
    }

    public static int partitionNaive(int[] arr, int pidx) {
        int key = arr[pidx];
        int n = arr.length;
        int cursor = 0;
        for (int k = 0; k < n; k++) {
            if (cursor == pidx) pidx++; // update position of pivot (== key)
            if (arr[k] < key) {
                if (cursor == pidx) pidx++; // update position of pivot (== key)
                shiftLeft(arr, cursor++, k);
            }  // by induction k will always be at or to the left of cursor
        }
        int leftmost = cursor; // by induction pidx will now be at or to the right of cursor
        for (int i = cursor; i <= pidx; i++) { // to preserve stability
            if (arr[i] > arr[leftmost]) shiftLeft(arr, leftmost++, i);
        }
        return cursor;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void shiftLeft(int[] arr, int lo, int hi) {
        int key = arr[hi];
        for (int i = hi; i > lo; i--) {
            arr[i] = arr[i - 1];
        }
        arr[lo] = key;
    }

    private static void shiftRight(int[] arr, int lo, int hi) {
        int key = arr[lo];
        for (int i = lo; i < hi; i++) {
            arr[i] = arr[i + 1];
        }
        arr[hi] = key;
    }

    private static void display(int[] a) {
        for (var e : a) System.out.print(e + " ");
        System.out.println();
    }
    
}
