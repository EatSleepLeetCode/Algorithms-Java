
public class PartitionEqualSubsetSum 
{
    public boolean canPartition(int[] nums)
    {
        int n = nums.length;
        
        int sum = 0;
        for(int val : nums)
            sum += val;
        
        if(sum % 2 != 0)
            return false;
        
        sum = sum / 2;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
                       
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                if(j - nums[i - 1] >= 0)
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][sum];        
    }

    public static void main(String[] args) 
	{
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int[] nums = new int[] {1,5,11,5};
		System.out.println(obj.canPartition(nums));
	}

}
