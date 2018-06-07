
public class SubsetSumWithMinDifference 
{
    public int minDiff(int[] nums)
    {
        int n = nums.length;
        
        int sum = 0;
        for(int val : nums)
            sum += val;
        
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
        
        int diff = Integer.MAX_VALUE;
        
        for(int j = sum / 2; j >= 0; j--)
        {
        	if(dp[n][j])
        	{
        		diff = sum - 2 * j;
        		break;
        	}
        }
        
        return diff;        
    }

    public static void main(String[] args) 
	{
		SubsetSumWithMinDifference obj = new SubsetSumWithMinDifference();
		int[] nums = new int[] {1,5,11,5};
		System.out.println(obj.minDiff(nums));
	}

}
