class IsSubsetSumPossible
{
	// Returns true if there is a subset of nums[] with sun equal to given sum
	static boolean isSubsetSum(int nums[], int n, int sum)
	{
		// The value of dp[i][j] will be true if there 
			// is a subset of nums[0..n-1] with sum equal to j
		boolean dp[][] = new boolean[n + 1][sum + 1];
	
		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int j = 0; j <= sum; j++)
			dp[0][j] = false;
		
		// Fill the subset table in bottom up manner
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= sum; j++)
			{
				if (j - nums[i - 1] >= 0)
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
				else
					dp[i][j] = dp[i - 1][j];		
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
