import java.util.Arrays;

public class OnesAndZeroes 
{
    public int findMaxForm(String[] strs, int m, int n) 
    {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m + 1; i++)
        {
            Arrays.fill(dp[i], 0);
        }
        
        int[] nums = new int[]{0, 0};
        
        for (String str : strs)
        {
            nums = calculate(str);
            
            for (int i = m; i >= nums[0]; i--)              //upto nums[0]
            {
                for (int j = n; j >= nums[1]; j--)          //upto nums[1]
                {
                    if (i >= nums[0] && j >= nums[1])
                    {
                        dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                    }
                    else
                    {
                        dp[i][j] = dp[i][j];    //Not required, just leaving to make it similar to 0/1 knapsack
                    }
                }
            }
        }
        return dp[m][n];
    }
    
    int[] calculate(String str)
    {
        int[] result = new int[2];
        
        Arrays.fill(result, 0);
        
        for (char ch : str.toCharArray())
        {
            if (ch == '0')
                result[0]++;
            else if (ch == '1')
                result[1]++;
        }
        
        return result;
    }
    
	public static void main(String[] args) 
	{
		OnesAndZeroes obj = new OnesAndZeroes();
		System.out.println(obj.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
	}
}
