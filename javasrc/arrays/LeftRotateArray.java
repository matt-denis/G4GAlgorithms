package arrays;

public class LeftRotateArray {

    public static void rotate(int[] a) {
        if (a.length == 0) return;
        int first = a[0];
        int i = 0;
        for ( ; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[i] = first;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        rotate(a);
        display(a);
    }

    private static void display(int[] a) {
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}