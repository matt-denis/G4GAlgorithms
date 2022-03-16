package recursion;

/**
 * Print numbers up to n in ascending order
 */
public class AscendingInt {

    public static void print(int n) {
        if (n <= 0) return;
        print(n - 1);
        System.out.print(n + " ");
    }

    public static void printTailRecursive(int n) {
        printTailRecursive(n, n);
    }

    public static void printTailRecursive(int initial, int n) {
        if (n == 0) return;
        System.out.print((initial - n + 1) + " ");
        printTailRecursive(initial, n - 1);
    }



    public static void main(String[] args) {
        printTailRecursive(10);
        System.out.println();
    }
}