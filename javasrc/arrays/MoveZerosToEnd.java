package arrays;

public class MoveZerosToEnd {

    public static void move(int[] a) {
        int cursor = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) swap(a, cursor++, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    } 

    public static void main(String... args) {
        int[] a = new int[] {8, 5, 0, 10, 0, 20};
        move(a);
        display(a);
        a = new int[] {0, 0, 0};
        move(a);
        display(a);
        a = new int[] {0, 3, 4, 0, 0, 5, 0};
        move(a);
        display(a);
    }

    private static void display(int[] a) {
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}