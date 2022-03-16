package recursion;

public class PrintBinary {

    public static void print(int n) {
        if (n == 0) return;
        print(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String... args) {
        print(27);
        System.out.println();
    }
}