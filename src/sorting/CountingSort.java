package sorting;

public class CountingSort {

    public static void main(String[] args) {
        int[] a = new int[] {1, 4, 4, 1, 0, 1};
        sortNaive(a, 5);
        int[] b = new int[] {1, 4, 4, 1, 0, 1};
        sort(b, 5);
        display(a);
        display(b);
        int[] c = new int[] {-2, 1, 1, -1, -3, -2};
        sortRange(c, -3, 1);
        display(c);

    }
    /* General purpose: works for any object or primitive type */
    public static void sort(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        } 
        // cumulative sums
        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }
        // count[i] = num of elements less than or equal to i
        int[] output = new int[n];
        // backward traversal ensures stabilty
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        } 
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    /* Extend implementation to sort range lo <= x <= hi */
    public static void sortRange(int[] arr, int min, int max) {
        int k = max - min + 1;
        int offset = 0 - min;
        int n = arr.length;
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            count[arr[i] + offset]++;
        }
        for (int i = 1; i < k; i++) count[i] += count[i - 1];
        int output[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] + offset] - 1] = arr[i];
            count[arr[i] + offset]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }

    }



    /* works only for integers as we write indeces back into the original array */
    public static void sortNaive(int[] arr, int k) {
        var table = new int[k];
        for (int e : arr) {
            table[e]++;
        }
        int cursor = 0;
        //  Sum_i table_i = k
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < table[i]; j++) {
                arr[cursor++] = i;
            }
        }
         
    }

    private static void display(int[] arr) {
        for (var e : arr) System.out.print(e + " ");
        System.out.println();
    }
}

