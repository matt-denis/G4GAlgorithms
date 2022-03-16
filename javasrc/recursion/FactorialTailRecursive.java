package recursion;

public class FactorialTailRecursive {

    public static int factorial(int n) {
        return factorial(n, n);
    }

    public static int fact(int n) {
        return fact(n, 1);
    }

    private static int factorial(int fact, int counter) {
        if (counter == 1) return fact;
        return factorial(fact * (counter - 1), counter - 1);
    }

    private static int fact(int n, int k) {
        if (n == 1) return k;
        return fact(n - 1, k * n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(23));
        System.out.println(factorialTest(23));
    }

    private static int factorialTest(int n) {
        if (n == 1) return 1;
        return n * factorialTest(n - 1);
    }
}