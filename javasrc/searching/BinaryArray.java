package searching;

/*
Given a sorted binary array find the number of 1's.
 */

 public class BinaryArray {

    public static void main(String[] args) {
        System.out.println(count(new int[] {1}));
    }

    public static int count(int[] arr) {
        int firstIdx = FirstOccurrence.search(1, arr);
        return firstIdx == -1 ? 0 : arr.length - firstIdx;
    }

 }