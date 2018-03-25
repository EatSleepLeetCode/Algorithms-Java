class IsSubsetSumPossible
{
    public boolean subsetSum(int[] nums, int sum)
    {
        int n = nums.length;
        
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

    public static void main (String args[])
	{
		int nums[] = {1, 4, 3, 2};
		int sum = 8;
		int n = nums.length;
		
		if (isSubsetSum(nums, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}
}
