package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        ToH(5, 'A', 'B', 'C');
    }

    public static void ToH(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move 1 from " + a + " to " + c);
            return;
        }
        ToH(n - 1, a, c, b);
        System.out.println("Move " + n + " from " + a + " to " + c);
        ToH(n - 1, b, a, c);
    }

    public long tohCountSteps(int N, int from, int to, int aux) {
        if (N == 1) {
            System.out.println("move disk " + N + " from rod " +
            from + " to rod " + to);
            return 1;
        }
        long steps1 = tohCountSteps(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " +
        from + " to rod " + to);
        long steps2 = tohCountSteps(N - 1, aux, to, from);
        return steps1 + steps2 + 1;
    }
}