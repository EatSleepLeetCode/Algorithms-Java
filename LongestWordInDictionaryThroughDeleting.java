import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting 
{
    public String findLongestWord(String s, List<String> d) 
    {
        String maxStr = "";
        
        for (String str : d)
        {
            if (s.length() < str.length())
                continue;
            
            if (isSubsequence(s, str))
            {
                if (str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) < 0))
                {
                    maxStr = str;
                }
            }
        }
        return maxStr;
    }
    
    boolean isSubsequence(String longer, String shorter)
    {
        int i = 0;
        int j = 0;
        
        while (i < longer.length() && j < shorter.length())
        {
            if (longer.charAt(i) == shorter.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j == shorter.length();
    }
    
    public static void main(String[] args)
    {
    	LongestWordInDictionaryThroughDeleting obj = new LongestWordInDictionaryThroughDeleting();
    	System.out.println(obj.findLongestWord("foobarfoobar", Arrays.asList("foo", "bar")));
    }
}
