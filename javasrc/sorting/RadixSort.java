package sorting;

public class RadixSort {

    public static void main(String[] args) {
        var a = new int[] {319, 212, 6, 8, 100, 50};
        display(a);
        sort(a);
        display(a);

    }
    
    // assume positive numbers. Negative ones -> easy fix similar to CountingSort.countRange
    public static void sort(int[] arr) {
        int max = findMax(arr);
        int maxDigits = findMaxDigits(max);
        int exp = 1;  // represents the current exponent on the base 10
        int base = 10;
        do {
            cSortSubroutine(arr, 10, base);  // 10 digits 0-9
            base *= 10;
            exp++;
        } while (exp <= maxDigits);

    }

    private static void cSortSubroutine(int[] arr, int k, int base) {
        int n = arr.length;
        int count[] = new int[k];
        for (int i = 0; i < n; i++) {
            count[(arr[i] % base) / (base / 10)]++;
        }
        for (int i = 1; i < k; i++) count[i] += count[i - 1];
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] % base) / (base / 10)] - 1] = arr[i];
            count[(arr[i] % base) / (base / 10)]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        } 
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int e : arr) {
            if (e > max) max = e;
        }
        return max;
    }

    private static int findMaxDigits(int n) {
        int count = 1;
        int base = 10;
        while (n / base != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    private static void display(int[] arr) {
        for (var e : arr) System.out.print(e + " ");
        System.out.println();
    }
}
