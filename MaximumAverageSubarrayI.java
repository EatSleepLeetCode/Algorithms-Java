class MaximumAverageSubarrayI
{
    public double findMaxAverage(int[] nums, int k) 
    {
        int n = nums.length;
        int sum = 0;        
        double maxAvg = Integer.MIN_VALUE;
        double avg = 0;
        
        for (int i = 0; i < k; i++)
            sum += nums[i];
        
        for (int i = k; i < n; i++)
        {
            avg = (double) sum / k;
            maxAvg = Math.max(maxAvg, avg);
            
            sum -= nums[i - k];
            sum += nums[i];
        }
        avg = (double) sum / k;
        maxAvg = Math.max(maxAvg, avg);

        return maxAvg;
    }
}
