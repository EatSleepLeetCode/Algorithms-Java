
public class LargestSumOfAverage 
{
    public double largestSumOfAverages(int[] A, int K) 
    {
        int n = A.length;
        double[] cummulativeSum = new double[n + 1];
        for (int i = 0; i < n; i++)
        {
            cummulativeSum[i + 1] = cummulativeSum[i] + A[i];
        }
        
        double[] dp = new double[n];
        for (int i = 0; i < n; i++)
        {
            dp[i] = (cummulativeSum[n] - cummulativeSum[i]) / (n - i);            
        }
        
        for (int k = 0; k < K - 1; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j < n; j++)
                {
                    dp[i] = Math.max(dp[i], (cummulativeSum[j] - cummulativeSum[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }
}
