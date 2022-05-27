package recursion;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalin(100));
    }

    static boolean isPalin(int N)
    {
        if ((N / 10) == 0) return true;
        int numDigits = countDigits(N);
        int left = intPow10(numDigits - 1);
        int right = 10;
        return isPalin(N, left, right,  numDigits);
    }

    private static boolean isPalin(int N, int left, int right,
    int numDigits) {
        if (Math.log10(right) > numDigits / 2) return true;
        if (((N / left) % 10) == ((N % right) / (right / 10))) {
            left /= 10;
            right *= 10;
            return isPalin(N, left, right, numDigits);
        }
        return false;
    }

    private static int intPow10(int k) {
        int pow = 1;
        for (int i = 1; i <= k; i++) {
            pow *= 10;
        }
        return pow;
    }

    private static int countDigits(int n) {
        if (n <= 0) return 1;
        int count = 0;
        int res = n;
        while (res > 0) {
            res /= 10;
            count++;
        }
        return count;
    }
    
}