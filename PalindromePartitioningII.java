
public class PalindromePartitioningII 
{
    public int minCut(String s) 
    {
        int n = s.length();
        int[] minCut = new int[n];
        
        for (int i = 0; i < n; i++)
            minCut[i] = i;
        
        for (int i = 0; i < n; i++)
        {
            palindromeSearch(s, minCut, i, i);
            palindromeSearch(s, minCut, i, i + 1);
        }
        
        return minCut[n - 1];
    }
    
    void palindromeSearch(String s, int[] minCut, int left, int right)
    {
        int n = s.length();
        
        while (left >= 0 && right < n)
        {
            if (s.charAt(left) != s.charAt(right))
                return;
            
            if (left == 0)          // left == 0, substring(0, right+1) is palindrome, no cut needed
                minCut[right] = 0;
            else
                minCut[right] = Math.min(minCut[right], minCut[left - 1] + 1);
            left--;
            right++;
        }
    }
    
	public static void main(String[] args) 
	{
		PalindromePartitioningII obj = new PalindromePartitioningII();
		System.out.println(obj.minCut("aab"));
	}
}
