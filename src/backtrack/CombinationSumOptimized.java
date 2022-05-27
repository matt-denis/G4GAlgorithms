/**
Optimization: remove duplicates before calling recursive utility.
 */



package backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CombinattionSumOptimized
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Set<Integer> set = new HashSet<Integer>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        Deque<Integer> currCombination = new ArrayDeque<>();
        combinations(A, B, combinations, currCombination,
        0, 0);
        return combinations;
    }
    
    private static void combinations(final List<Integer> A, int B,
    List<ArrayList<Integer>> combinations, Deque<Integer> currCombination,
    int currIdx, int currSum) {
           
       
        if (currSum == B) {
            ArrayList<Integer> comb = new ArrayList<>();
            for (int e : currCombination) {
                comb.add(e);
            }
            combinations.add(comb);
            return;
        }
        
        if (currIdx == A.size()) return;
        
        for (int i = currIdx; i < A.size(); i++) {
            int currE = A.get(i);
            // take current element
            if (currE <= B - currSum) {
                currCombination.addLast(currE);
                combinations(A, B, combinations, currCombination, i,
                currSum + currE);
                // do not take current element
                currCombination.removeLast();
            }
        }
    }
    
}
