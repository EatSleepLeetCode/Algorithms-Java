
public class LongestPalindrome 
{
    public int longestPalindrome(String s) 
    {
        int count = 0;
        boolean hasOdd = false;
        int[] freq = new int[128];
        
        for (char ch : s.toCharArray())
        {
            freq[ch]++;
        }
        
        for (int i = 0; i < 128; i++)
        {
            if (freq[i] % 2 == 0)
            {
                count += freq[i];
            }
            else
            {
                count += freq[i] - 1;
                hasOdd = true;
            }
        }
        return count + (hasOdd ? 1 : 0);
    }
}
