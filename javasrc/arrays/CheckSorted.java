package arrays;

public class CheckSorted {
    
    public static boolean isSorted(int[] array) {
        int j = 1;
        int n = array.length;
        while (j < n && array[j] >= array[j - 1]) j++;
        return j == n;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 5};
        System.out.println(isSorted(a));
        a = new int[] {3, 4, 5, 3};
        System.out.println(isSorted(a));
        a = new int[] {1, 4, 6, 3, 5};
        System.out.println(isSorted(a));
    }
}