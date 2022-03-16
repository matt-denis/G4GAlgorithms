package searching;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(20, new int[] {10,20,30,40,50,60}));
        System.out.println(search(25, new int[] {5, 15, 25}));
        System.out.println(search(20, new int[]{5, 10, 15, 25}));
        System.out.println(search(20, new int[]{10, 15}));
        System.out.println(search(5, new int[]{10, 15}));
        System.out.println(search(10, new int[]{10, 10}));
    }

    public static int search(int e, int[] arr) {
        return search(e, arr, 0, arr.length - 1);
    }

    public int searchRec(int e, int[] arr) {
        return searchRec(e, arr, 0, arr.length);
    }

    private static int search(int e, int[] arr, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (e < arr[mid]) hi = mid - 1;
            else if (e > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int searchRec(int e, int[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (e < arr[mid]) return searchRec(e, arr, lo, mid - 1);
        if (e > arr[mid]) return searchRec(e, arr, mid + 1, hi);
        else return arr[mid];
    }

}