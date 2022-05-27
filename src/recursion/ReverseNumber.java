package recursion;

public class ReverseNumber {

    public static long reverse(long n) {
        long rev = 0;
        while (n >= 1) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static int reverse(int n) { return (int) reverse((long) n);}
    
    public static void main(String... args) {
        long reversed = reverse(123456789);
        System.out.println(reversed);
        int rev = 123;
        System.out.println(reverse(rev));
    }
}