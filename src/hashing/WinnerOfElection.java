package hashing;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Given an array of names (consisting of lowercase characters) of candidates in an election.
 * A candidate name in array represents a vote casted to the candidate.
 * Print the name of candidate that received Max votes.
 * If there is tie, print lexicographically smaller name.
 * 
 * Your Task:
 * You only need to complete the function winner() that takes an array of strings arr,
 * and n as parameters and returns the name of the candiate with maximum votes
 * and the number of votes the candidate got as an array of size 2.

 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)

 * Constraints:
 * 1 <= n <= 10^5
 */

public class WinnerOfElection {
    
    public static String[] winner(String arr[], int n)
    {
        Map<String, Integer> map = new HashMap<>();
        int maxVotes = 0;
        
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) > maxVotes) maxVotes = map.get(s);
        }
        
        List<String> candidates = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVotes) {
                candidates.add(entry.getKey());
            }
        }
        
        String candidate = getCandidate(candidates);
        return new String[] {candidate, String.valueOf(maxVotes)};
        
    }
    
    private static String getCandidate(List<String> list) {
        String min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }
}
