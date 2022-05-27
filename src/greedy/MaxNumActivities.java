package greedy;

/**
 * Given N activities with their start and finish day given in array start[ ] and end[ ].
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a given day.
 * Note : Duration of the activity includes both starting and ending day.
 */

public class MaxNumActivities {
    public static int activitySelection(int start[], int end[], int n)
    {
        int[] indices = orderIndices(end);
        int lastEnd = -1;
        int count = 0;
        for (int i = 0; i < indices.length; i++) {
            if (start[indices[i]] > lastEnd) {
                count++;
                lastEnd = end[indices[i]];
            }
        }
        return count;
    }
    
    public static int[] orderIndices(final int array[]) {
        final int n = array.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && array[indices[j]] < array[indices[j - 1]]; j--) {
                swap(indices, j, j - 1);
            }
        }
        return indices;
        
    }
    
    private static void swap(int arr[], int i, int j) {
        
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        
    }

    public static void main(String[] args) {
        System.out.println(
            activitySelection(new int[]{5, 3}, new int[]{7, 5}, 4)
        );
    }
}
