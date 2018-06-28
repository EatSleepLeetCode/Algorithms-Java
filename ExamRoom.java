import java.util.PriorityQueue;

class ExamRoom 
{
    PriorityQueue<int[]> pq;
    int N;

    int intervalToDist(int[] interval)
    {
        int dist = 0;
        
        if (interval[0] == -1)                          //[0]
            dist = interval[1];
        else if (interval[1] == N)                      //[1]
            dist = N - 1 - interval[0];
        else
            dist = (interval[1] - interval[0]) / 2;
        
        return dist;
    }
    
    public ExamRoom(int N) 
    {
        this.N = N;
        this.pq = new PriorityQueue<int[]>((a, b) -> {
            int distA = intervalToDist(a);
            int distB = intervalToDist(b);
            if (distA != distB)
                return distB - distA;
            else
                return a[0] - b[0];            
        });
        
        pq.offer(new int[]{-1, N});
    }
    
    public int seat() 
    {
        int result = 0;
        int[] interval = pq.poll();
        
        if (interval[0] == -1)
            result = 0;
        else if (interval[1] == N)
            result = N - 1;
        else
            result = interval[0] + (interval[1] - interval[0]) / 2;
        
        pq.offer(new int[]{interval[0], result});
        pq.offer(new int[]{result, interval[1]});
        return result;
    }
    
    public void leave(int p) 
    {
        int[] leftInterval= null;
        int[] rightInterval= null;
        for (int[] interval : pq)
        {
            if (interval[1] == p)
                leftInterval = interval;
            if (interval[0] == p)
                rightInterval = interval;
        }
        
        pq.remove(leftInterval);
        pq.remove(rightInterval);
        pq.offer(new int[]{leftInterval[0], rightInterval[1]});
    } 
}