public class FindTheDifference
{
    public char findTheDifference(String s, String t) 
    {
        char result = ' ';
        int[] freq = new int[26];
        
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            freq[s.charAt(i) - 'a']++;
        }
        
        n = t.length();
        for (int i = 0; i < n; i++)
        {
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] < 0)
            {
                result = (char)('a' + i);
                break;
            }
        }
        return result;
    }
}
