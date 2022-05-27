package searching;

public class SquareRootFloor {

    public static void main(String[] args) {
        System.out.println(sqrt(8));
    }

    public static int sqrt(int s) {
        int lo = 1, hi = s;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (s < mid * mid) hi = mid - 1;
            else if (s > mid * mid) {
                if ((mid + 1) * (mid + 1) > s) return mid;
                else lo = mid + 1;
            }
            else return mid;
        }
        return lo;
    }
    
    public static int sqrtNaive(int s) {
        int i = 1;
        while (i * i <= s) i++;
        return i - 1;
    }

    // G4G solution

    static int sqRootFloor(int x)
	{
		int low = 1, high = x, ans = -1;

		while(low <= high)
		{
			int mid = (low + high) / 2;

			int mSq = mid * mid;

			if(mSq == x)
				return mid;
			else if(mSq > x)
				high = mid - 1;
			else
			{
				low = mid + 1;
				ans = mid;
			}
		}

		return ans;
	}
}
