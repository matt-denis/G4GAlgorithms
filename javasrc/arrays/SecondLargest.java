package arrays;

public class SecondLargest {
    public static int find(int[] a) {
        if (a.length == 0) return -1;
        int largest = 0, second = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                second = largest;
                largest = i;
            }
            else if (a[i] < a[largest]) {
                if (second == - 1 || a[second] < a[i]) {
                    second = i;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 5, 6, 8, 9, 4, 3, 6};
        System.out.println(a[find(a)]);
        a = new int[] {10, 10, 10};
        System.out.println(find(a));
    }
}