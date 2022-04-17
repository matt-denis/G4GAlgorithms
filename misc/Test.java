import java.util.ArrayList;

public class Test {

    public static int minimum_vertical_sum(ArrayList<ArrayList<Integer>> arr)
    {
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; ; col++) {
            int sum = 0;
            boolean moreElements = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).size() > col) {
                    moreElements = true;
                    sum += arr.get(i).get(col);
                }
            }
            if (!moreElements) break;
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public static void main(String[] args) {
        var arr = new ArrayList<ArrayList<Integer>>();
        var a = new ArrayList<Integer>();
        a.add(2); a.add(3); a.add(5);
        arr.add(a);
        a = new ArrayList<>();
        a.add(1); a.add(2);
        arr.add(a);
        a = new ArrayList<>();
        a.add(1); a.add(4); a.add(5); a.add(1);
        arr.add(a);
        System.out.println(minimum_vertical_sum(arr));
    }

}