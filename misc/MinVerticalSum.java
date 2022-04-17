/*
Given an ArrayList of ArrayLists arr. Find the minimum vertical sum. ArrayLists inside the ArrayList arr may not be of the same size.


The vertical sum is defined as described below:
If we have an ArrayList of ArrayLists arr:
1 2 3 4
5 6
7 8 9
The vertical sums are: Sum of {1 5 7}, Sum of {2 6 8}, Sum of {3 9}, Sum of {4}.

Example:

Input:
arr = {{2 3 5}, {1 2}, {1 4 5 1}}
Output:
1
Explanation:
Here N  = 3. So we have 3 ArrayList
inside arr. Now, the first ArrayList
is of size 3 and elements  are {2 3 5}.
The second ArrayList is of size 2 and 
elements are {1 2}. The third ArrayList
is of size 4 and elements are {1 4 5 1}.
2 3 5
1 2
1 4 5 1
So, the vertical sums are {2+1+1},
{3+2+4}, {5+5},{1}. 1 is the min
vertical sum here.
Your Task:
This is a function problem. You need to complete the function minimum_ vertical_sum that takes ArrayList of ArrayLists as a parameter and returns min vertical sum.

Constraints:
1 <= N <= 103
1 <= M <= 103
1 <= arrij <= 105
*/

import java.util.ArrayList;

public class MinVerticalSum {
    
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
