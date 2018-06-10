import java.util.Arrays;

public class MostProfitAssigningWork 
{
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) 
    {
        int n = difficulty.length;      //job count
        int result = 0;
        int best = 0;
        Tuple[] jobs = new Tuple[n];
        
        for (int i = 0; i < n; i++)
        {
            jobs[i] = new Tuple(difficulty[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a, b) -> a.diff - b.diff);   //asc
        Arrays.sort(workers);                           //asc
                
        for (int skill : workers)
        {
            int i = 0;
            while (i < n && skill >= jobs[i].diff)
            {
                best = Math.max(best, jobs[i].pro);
                i++;
            }
            result += best;
        }
        return result;
    }
}

class Tuple
{
    int diff;
    int pro;
    
    public Tuple(int difficulty, int profit)
    {
        this.diff = difficulty;
        this.pro = profit;
    }
}

