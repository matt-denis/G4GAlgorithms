package greedy;

/**
 * Given a series of jobs all taking 1 unit of time, having a deadline and
 * a profit, we have to select jobs so as to maximize the profit, given 
 * we can do only one job at a time. We start from time 0 and deadlines
 * are strictly greater than zero.
 * 
 * The strategy pf this solution is to sort the jobs by priority,
 * where we define priority as the ratio of the profit to the deadline.
 */

import java.util.Collections;
import java.util.List;

public class JobSequencingPriority {

    public double maxProfit(final List<Job> jobs) {

        Collections.sort(jobs);
        int time = 0;
        double profit = 0;
        for (int i = jobs.size() - 1; i >= 0; i--){
            Job nextJob = jobs.get(i);
            if (time < nextJob.deadline()) {
                profit += nextJob.profit();
                time++;
            }
        }
        return profit;
    }
    
}

class Job implements Comparable<Job>  {
    private final int deadline;
    private final double profit;

    // Abstraction Function
    //    A job with a given deadline and a given profit
    // Rep invariant
    //    deadline > 0, profit = 0

    Job(int deadline, double profit) {
        this.deadline = deadline;
        this.profit = profit;
        checkRep();
    }

    private void checkRep() {
        assert deadline > 0 && profit > 0;
    }

    public int deadline() { return deadline; }

    public double profit() { return profit; }

    public double priority() { return profit() / deadline(); }

    @Override 
    public int compareTo(Job other) {
        return this.priority() > other.priority() ? 
            1 : this.priority() == other.priority() ? 0 : -1;
    }

}
