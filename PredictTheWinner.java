
public class PredictTheWinner 
{
    /*
    The dp[i][j] saves how much more scores that the first-in-action player will get from i to j 
    than the second player. First-in-action means whomever moves first. You can still make the 
    code even shorter but I think it looks clean in this way.
    */

    public boolean PredictTheWinner(int[] nums) 
    {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
            dp[i][i] = nums[i];
        }
        
        for (int len = 1; len < n; len++)
        {
            for (int i = 0; i < n - len; i++)
            {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
    
    public static void main(String[] args)
    {
    	PredictTheWinner obj = new PredictTheWinner();
    	System.out.println(obj.PredictTheWinner(new int[] {1, 5, 2}) == true ? "True" : "False");
    	System.out.println(obj.PredictTheWinner(new int[] {1, 5, 233, 7}) == true ? "True" : "False");
    }
}
