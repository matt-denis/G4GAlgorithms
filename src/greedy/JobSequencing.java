package greedy;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a series of jobs all taking 1 unit of time, having a deadline and
 * a profit, we have to select jobs so as to maximize the profit, given 
 * we can do only one job at a time. We start from time 0 and deadlines
 * are strictly greater than zero.
 * 
 * The strategy pf this solution is to sort the jobs by priority,
 * where we define priority as the ratio of the profit to the deadline.
 */

public class JobSequencing {
    
    public static double maxProfit(List<Job> jobs) {
        Collections.<Job>sort(jobs, (job1, job2) -> {
            return job1.profit() < job2.profit() ?
                -1 : job1.profit() == job2.profit() ? 0 : 1;
        });

        double profit = 0;
        final Set<Integer> allocated = new HashSet<>();
        for (int i = jobs.size() - 1; i >= 0; i--) {
            var job = jobs.get(i);
            if (!allocated.contains(job.deadline())) {
                allocated.add(i);
                profit += job.priority();
            }
        }
        return profit;
    }
}
