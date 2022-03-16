package recursion;

public class SumOfFirstNaturalNumbers {

    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }

    public static int sumTail(int n) {
        return sumTail(n, 0);
    }

    private static int sumTail(int n, int k) {
        if (n == 0) return k;
        return sumTail(n - 1, k + n);
    }

    public static void main(String[] args) {
        System.out.println(sumTail(34));
        System.out.println(verify(34));
    }

    private static int verify(int n) {
        return (n + 1) * n / 2;
    }
}