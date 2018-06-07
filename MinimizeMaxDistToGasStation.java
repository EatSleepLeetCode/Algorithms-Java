
class MinimizeMaxDistToGasStation 
{
    //Solution 1 - TLE
    /*
   public double minmaxGasDist(int[] stations, int K) 
    {
        int n = stations.length;

        //For double data type use "> ? :", instead of "b - a"
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
    		public int compare(int[]a, int[] b)
    		{
    			return (double)b[0] / b[1] > (double)a[0] / a[1] ? 1 : -1;
    		}    		
    	});
        
        for (int i = 0; i < n-1; ++i)
            pq.add(new int[]{stations[i+1] - stations[i], 1});

        for (int k = 0; k < K; ++k) 
        {
            int[] node = pq.poll();
            node[1]++;
            pq.add(node);
        }

        int[] node = pq.poll();
        
        return (double)node[0] / node[1];
    }
    */
	
    //Solution 2
	public double minmaxGasDist(int[] stations, int K) 
    {
        int count = 0;
        int n = stations.length;
        double left = 0;
        double right = stations[n - 1] - stations[0];
        double mid = 0;

        while (right - left > 1e-6) 
        {
            //mid represents the max gap between two stations
            mid = (left + right) / 2;
        
            count = 0;
            
            for (int i = 0; i < n - 1; i++)
            {
                count += (int)((stations[i + 1] - stations[i]) / mid);
            }
            
            //Since count is inversely proportional to mid, if count > K then 
            //it means we need to try with greater value of mid. So we set 
            //left = mid. However, if count < K then it means we need to try
            //smaller value of mid and we set right = mid.
            
            if (count > K) 
                left = mid;
            else 
                right = mid;
        }
        
        return right;
    }

	public static void main(String[] args) 
	{
		MinimizeMaxDistToGasStation obj = new MinimizeMaxDistToGasStation();
		int[] stations = new int[] {1, 10, 16, 18, 47, 54, 61, 78, 87, 88};
		System.out.println(obj.minmaxGasDist(stations, 3));
	}

}
