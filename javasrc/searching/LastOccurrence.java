package searching;

public class LastOccurrence {

    public static int search(int e, int[] arr) {
        return search(e, arr ,0, arr.length - 1);
    }

    public static int searchRec(int e, int[] arr) {
        return searchRec(e, arr, 0, arr.length - 1);
    }

    public static int searchRev(int e, int[] arr) {
        return searchRev(e, arr ,0, arr.length - 1);
    }

    private static int search(int e, int[] arr, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (e < arr[mid]) hi = mid - 1;
            else if (e > arr[mid]) lo = mid + 1;
            else if (mid == arr.length - 1|| arr[mid + 1] != e) return mid;
            else lo = mid + 1;
        }
        return -1;
    }

    private static int searchRec(int e, int[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (e < arr[mid]) return searchRec(e, arr, lo, mid -1);
        if (e > arr[mid]) return searchRec(e, arr, mid + 1, hi);
        if (mid == arr.length - 1 || arr[mid + 1] != e) return mid;
        return searchRec(e, arr, lo + 1, hi);
    }

    // for a reverse-ordered array
    private static int searchRev(int e, int[] arr, int lo, int hi) {
        // just switch comparison signs
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (e > arr[mid]) hi = mid - 1;
            else if (e < arr[mid]) lo = mid + 1;
            else if (mid == arr.length - 1|| arr[mid + 1] != e) return mid;
            else lo = mid + 1;
        }
        return -1;
    }
    
}
