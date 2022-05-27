package recursion;

public class SumDigits {

    public static int sum(int n) {
        if (n < 10) return n;
        return (n % 10) + sum(n / 10);
    }

    public static int sumTail(int n) { return sumTail(n, 0); }

    private static int sumTail(int n, int sum) {
        if (n < 10) return sum + n;
        return sumTail(n / 10, sum + (n % 10));
    }

    public static void main(String[] args) {
        System.out.println(sum(123456));
        System.out.println(sumTail(123456));
    }
}