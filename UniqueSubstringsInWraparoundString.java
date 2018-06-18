
public class UniqueSubstringsInWraparoundString 
{
    public int findSubstringInWraproundString(String p) 
    {
        int[] count = new int[26];
        int result = 0;
        int maxCurrLength = 0;
        
        for (int i = 0; i < p.length(); i++)
        {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25))
            {
                maxCurrLength++;
            }
            else
            {
                maxCurrLength = 1;
            }
            
            count[p.charAt(i) - 'a'] = Math.max(maxCurrLength, count[p.charAt(i) - 'a']);
        }
        
        for (int i = 0; i < 26; i++)
        {
            result += count[i];
        }
        
        return result;
    }
}
