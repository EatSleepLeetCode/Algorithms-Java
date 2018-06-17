
public class LongestRepeatingCharatcerReplacement 
{
    public int characterReplacement(String s, int k) 
    {
        int[] map = new int[26];
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int maxLen = 0;
        
        while (right < n)
        {
            char ch = s.charAt(right);
            map[ch - 'A']++;
            right++;
            
            maxCount = Math.max(maxCount, map[ch - 'A']);
            
            //If number of not same chars between left & right > k then slide from left
            if (right - left - maxCount > k)
            {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left);            
        }
        return maxLen;
    }
}
