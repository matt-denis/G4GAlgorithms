package searching;

public class FirstOccurrence {
    public static void main(String[] args) {
        System.out.println(searchRec(10, new int[]{10, 10, 10, 10}));
    }

    public static int search(int e, int[] arr) {
        return search(e, arr, 0 , arr.length - 1);
    }

    public static int searchRec(int e, int[] arr) {
        return searchRec(e, arr, 0, arr.length - 1);
    }
    
    private static int search(int e, int[] arr, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (e < arr[mid]) hi = mid - 1;
            else if (e > arr[mid]) lo = mid + 1;
            else if (mid == 0 || arr[mid - 1] != e) return mid;
            else hi = mid - 1; // match found, but also match on the left
        }
        return -1;
    }

    private static int searchRec(int e, int[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (e < arr[mid]) return searchRec(e, arr, lo, mid - 1);
        if (e > arr[mid]) return searchRec(e, arr, mid + 1, hi);
        if (mid == 0 || arr[mid - 1] != e) return mid;
        return searchRec(e, arr, lo, mid - 1);
    }
}
