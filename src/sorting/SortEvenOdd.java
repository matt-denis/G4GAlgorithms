package sorting;

import java.util.Comparator;
import java.util.Arrays;

public class SortEvenOdd {

    public static void main(String[] args) {
        System.out.println();
    }
    public static void sort(Integer[] arr) {
        Arrays.sort(arr, new EvenFirstComparator());

    }

    private static class EvenFirstComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer x, Integer y) {
            return x % 2 - y % 2;
        }
    }
}