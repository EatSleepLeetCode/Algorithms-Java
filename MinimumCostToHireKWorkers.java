class MinimumCostToHireKWorkers 
{
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) 
    {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        for (int i = 0; i < n; i++)
            workers[i] = new Worker(quality[i], wage[i]);
        
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio(), b.ratio()));
        
        double ans = Math.pow(10, 9);
        
        int sumQ = 0;
        
        PriorityQueue<Integer> pool = new PriorityQueue<Integer>();
        for (Worker worker : workers)
        {
            pool.offer(-worker.quality);
            sumQ += worker.quality;
            
            if (pool.size() > K)
                sumQ += pool.poll();
            
            if (pool.size() == K)
                ans = Math.min(ans, sumQ * worker.ratio());
        }
        return ans;
    }
}

class Worker
{
    int quality;
    int wage;
    
    public Worker(int quality, int wage)
    {
        this.quality = quality;
        this.wage = wage;
    }
    
    double ratio()
    {
        return (double) this.wage / this.quality;
    }
}
