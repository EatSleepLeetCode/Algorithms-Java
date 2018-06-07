
public class InterLeavingString 
{
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        
        if (s1Len + s2Len != s3Len)
            return false;
        
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        
        for (int i = 0; i <= s1Len; i++)
        {
            for(int j = 0; j <= s2Len; j++)
            {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || 
                               dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[s1Len][s2Len];
    }
    
	public static void main(String[] args) 
	{
		InterLeavingString obj = new InterLeavingString();
		System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
