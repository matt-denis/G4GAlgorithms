package searching;

/**
 * Count 1's in a reverse ordered binary array
 */
public class CountOnesBinaryReversed {
    

    public static int countOnes(int arr[], int N){
        return LastOccurrence.searchRev(1, arr) + 1;
    }
}
