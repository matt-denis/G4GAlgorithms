package sorting;
import java.util.Arrays;

public class FindNumberOfTriangles {

    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n 
                    && arr[i] + arr[j] > arr[k]; k++, count++);
            }
        }
        return count;
    }
}