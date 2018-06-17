
public class ArithmeticSlices 
{
    //Solution 1 - Space: O(m)
    public int numberOfArithmeticSlices1(int[] A) 
    {
        int n = A.length;
        int[] dp = new int[n];
        int sum = 0;
        
        for (int i = 2; i < n; i++)
        {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
            {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
    
    //Solution 2 - Space: O(1)
    public int numberOfArithmeticSlices(int[] A) 
    {
        int n = A.length;
        int dp = 0;
        int sum = 0;
        
        for (int i = 2; i < n; i++)
        {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
            {
                dp += 1;
                sum += dp;
            }
            else
            {
                dp = 0;
            }
        }
        return sum;
    }
}
