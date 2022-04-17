import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
n people sitting at a round table. People are
numbered from 1 to n-1. Every iteration we kill the
kth person. Given a number of n people we need
to find the survivor.
*/

public class Josephus {

    static int kill(int n, int k) {
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            qu.add(i);
        }
        while (qu.size() > 1) {
            // remove and enqueue k - 1 items
            for (int i = 1; i < k; i++) {
                qu.add(qu.remove());
            }
            qu.remove(); // remove kth item
        }
        return qu.remove();
    }

    // gfg
    static int josephus(int n, int k)
    {
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            list.add(i);
        }
        
        Iterator<Integer> it = list.iterator();
        
        while(list.size()>1)
        {
            int count= 0;
            
            while(count < k)
            {
                while(it.hasNext() && count < k)
                {
                    it.next();
                    count++;
                }
   
                if(count < k)
                {
                    it = list.iterator();
                    it.next();
                    
                    count++;
                }
            }

            it.remove();  
        }
        
        return list.getFirst();
    }

    // my implementation
    public static int josephus2(int n, int k)
{
    var ll = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
        ll.add(i);
    }
    Iterator<Integer> it = ll.iterator();
    while (ll.size() > 1) {
        for (int i = 1; i <= k; i++) {
            if (!it.hasNext()) it = ll.iterator();
            it.next();
        }
        it.remove();
    }
    
    return ll.get(0);
}

    public static void main(String[] args) {
        System.out.println(kill(7, 3));
    }
}