package sorting;

public class PrintMerge {
    public static void main(String[] args) {
        print(new int[]{10, 15, 20}, new int[]{5, 6, 6, 15});
    }
    
    public static void print(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int N = m + n;
        int i = 0, j = 0;
        for (int k = 0; k < N; k++) {
            if (j >= n || (i < m && a[i] <= b[j])) System.out.print(a[i++] + " ");
            else if (i >= m || (j < n && b[j] < a[i])) System.out.print(b[j++] + " ");
        }
    }

    // optimized version
    public static void printOpt(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int N = m + n;
        int i = 0, j = 0;
        for (int k = 0; k < N; k++) {
            if (i >= n) {
                while (j < m) System.out.print(b[j++] + " ");
                break;
            }
            if (j >= n) {
                while (i < m) System.out.print(a[i++]);
                break;
            }
            if (a[i] <= b[j]) System.out.print(a[i++] + " ");
            else System.out.print(b[j++] + " ");
        }
    }

    // G4G implementation
    public static void printG4G(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) System.out.print(a[i++] + " ");  // <= rather than < ensures stability
            else System.out.print(b[j++] + " ");
        }
        while (i < m) System.out.print(a[i++] + " ");
        while (j < n) System.out.print(b[j++] + " ");
    }
}
