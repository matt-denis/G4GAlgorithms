package arrays;

public class ReverseArray {

    public static void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) swap(a, i++, j--);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 7, 30};
        reverse(a);
        display(a);
    }

    private static void display(int[] a) {
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}