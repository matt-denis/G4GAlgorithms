package recursion;

public class FactAndFib {

    public static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibLinear(int n) {
        return fibLinear(n, 1, 1);
    }

    private static int fibLinear(int n, int a, int b) {
        if (n <= 2) return a;
        return fibLinear(n - 1, a + b, a);
    }

    public static void main(String[] args) {
        System.out.println(fibLinear(3));
    }
}