
public class Knapsack 
{
	int knapSack(int W, int wt[], int value[])
	{
		int n = value.length;
	    int dp[][] = new int[n + 1][W + 1];

    	for (int i = 1; i <= n; i++)
    	{
    		for (int j = 1; j <= W; j++)
    		{
                if (j - wt[i - 1] >= 0)
    				dp[i][j] = Math.max (dp[i - 1][j], value[i - 1] + dp[i - 1][j - wt[i - 1]]);
    			else
    				dp[i][j] = dp[i - 1][j];
    		}
    	}
    	return dp[n][W];
	}
	public static void main(String[] args) 
	{
		Knapsack obj = new Knapsack();
		System.out.println(obj.knapSack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}));
	}
}
