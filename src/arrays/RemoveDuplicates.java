package arrays;

public class RemoveDuplicates {
    
    public static int remove(int[] a) {
        if (a.length == 0) return 0;
        int xor = a[0];
        int prev = 0;
        int count = 1;
        int cursor = 1;
        for (int i = 1; i < a.length; i++) {
            if ((xor ^ a[i]) != prev) {
                a[cursor++] = a[i];
                prev = xor;
                xor ^= a[i];
                count++;
            }
        }
        return count;
    }

    public static int separatorRemove(int[] a) {
        if (a.length == 0) return 0;
        int cursor = 1;
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            int k = 0;
            for ( ; k < cursor; k++) {
                if (a[k] == a[i]) {
                    break;
                }
            }
            if (k == cursor) {
                a[cursor++] = a[i];
                count++;
            }
        }
        return count;
    }

    public static int separatorRemoveSorted(int[] a) {
        if (a.length == 0) return 0;
        int cursor = 1;
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[cursor - 1]) {
                a[cursor++] = a[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[] {10, 10, 10, 3, 3, 3};
        System.out.println(remove(a));
        display(a);
        a = new int[] {10, 10, 10, 3, 3, 3};
        System.out.println(remove(a));
        display(a);
    }

    private static void display(int[] a) {
        for (int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}