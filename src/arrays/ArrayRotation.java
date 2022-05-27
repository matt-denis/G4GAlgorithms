package arrays;

public class ArrayRotation {

    /**
     * Rotate array of length n by d places
     * @param a array
     * @param n array length
     * @param d places to rotate (to the left) each element by
     */
    public static void rotate(int[] a, int n, int d) {
        d = d % n;
        int i, j, walk, tmp;
        // # of orbits coresponds to the hcf. Orbits are {0, ..., hcf - 1}
        int numOrbits = hcf(n, d); 
        for (i = 0; i < numOrbits; i++) {
            tmp = a[i];
            j = i;
            while (true) {
                walk = j + d;
                if (walk >= n) walk -= n;
                if (walk == i) break;
                a[j] = a[walk];
                j = walk;
            }
            a[j] = tmp;

        }

    }

    /* Highest common factor */
    private static int hcf(int a, int b) {
        if (b == 0) return a;
        return hcf(b, a % b); // euclid theorem
    }
}