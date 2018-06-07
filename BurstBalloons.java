
public class BurstBalloons 
{
	public int maxCoins(int[] nums) 
    {
        int numLen = nums.length;
        int[] coinVals = new int[numLen + 2];
        int coinLen = 1;
        
        for(int i = 0; i < numLen; i++)
        {
            coinVals[coinLen] = nums[i];
            coinLen++;
        }
        coinVals[0] = 1;
        coinVals[coinLen] = 1;
        coinLen++;
        
        int[][] dp = new int[coinLen][coinLen];
        
        
        for(int k = 1; k < coinLen; k++)
        {
            for(int left = 0; left < coinLen - k; left++)
            {
                int right = left + k;
                
                for(int i = left + 1; i < right; i++)
                {
                    dp[left][right] = Math.max(dp[left][right],                                               
                                                dp[left][i] + 
                                                coinVals[left] * coinVals[i] * coinVals[right] +
                                                dp[i][right]);
                }
            }
        }
        
        return dp[0][coinLen - 1];
    }

    public static void main(String[] args) 
    {
		BurstBalloons obj = new BurstBalloons();
		int[] nums = new int[] {3, 1, 5, 8};
		System.out.println(obj.maxCoins(nums));
	}

}
