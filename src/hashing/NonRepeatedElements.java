/** 
Return a collection containing the non repeated elements of a given array.
*/


package hashing;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


public class NonRepeatedElements {

    public static ArrayList<Integer> get(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int e : list) {
            if (!map.containsKey(e)) {
                map.put(e, count);
                list.add(count++, e);
            }
            else {
                list.set(map.get(e), -1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int e : list) {
            if (e != -1) res.add(e);
        }
        return res;
    }
}