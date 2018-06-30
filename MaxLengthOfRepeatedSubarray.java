public class MaxLengthOfRepeatedSubarray
{
    public int findLength(int[] A, int[] B)
    {
        int m = A.length;
        int n = B.length;
        int result = 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (A[i - 1] == B[j - 1])
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        MaxLengthOfRepeatedSubarray obj = new MaxLengthOfRepeatedSubarray();
        System.out.println(obj.findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
    }
}
