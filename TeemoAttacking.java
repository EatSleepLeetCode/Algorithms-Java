
public class TeemoAttacking 
{
    public int findPoisonedDuration(int[] timeSeries, int duration) 
    {
        int n = timeSeries.length;
        if (n == 0)
            return 0;
        
        int result = 0;        
        int currStart = timeSeries[0];
        int currEnd = timeSeries[0] + duration;
        
        for (int i = 1; i < n; i++)
        {
            if (timeSeries[i] < currEnd)
            {
                currEnd = Math.max(currEnd, timeSeries[i] + duration);
            }
            else
            {
                result += currEnd - currStart;
                
                currStart = timeSeries[i];
                currEnd = timeSeries[i] + duration;
            }
        }
        
        result += currEnd - currStart;
        
        return result;
    }
}
