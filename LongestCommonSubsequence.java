
public class LongestCommonSubsequence 
{
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    void lcs(String X, String Y, int m, int n)
    {
        int[][] lcs = new int[m + 1][n + 1];
  
        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                	lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                	lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
  
        // Following code is used to print LCS
        int index = lcs[m][n];
        int maxIndex = index;
  
        // Create a character array to store the lcs string
        char[] result = new char[index];        
  
        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (X.charAt(i - 1) == Y.charAt(j - 1))
            {
                // Put current character in result
            	result[index - 1] = X.charAt(i - 1); 
                 
                // reduce values of i, j and index
                i--; 
                j--; 
                index--;     
            }
  
            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (lcs[i][j] == lcs[i - 1][j])
                i--;
            else
                j--;
        }
  
        // Print the lcs
        System.out.print("LCS of " + X + " and " + Y + " has length " + maxIndex + " and is ");
        for(int k = 0; k < maxIndex; k++)
            System.out.print(result[k]);
    }
	     
	public static void main(String[] args) 
	{
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        obj.lcs(X, Y, m, n);
	}
}
