import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUncommonSubsequenceII 
{
    public int findLUSlength(String[] strs) 
    {
        Arrays.sort(strs, (a, b) -> Integer.compare(b.length(), a.length()));   //desc sort on str length
        Set<String> duplicates = getDuplicates(strs);
        
        for (int i = 0; i < strs.length; i++)
        {
            if (!duplicates.contains(strs[i]))
            {
                if (i == 0)
                    return strs[i].length();
                
                for (int j = 0;  j < i; j++)
                {
                    if (isSubsequence(strs[j], strs[i]))
                        break;
                    if (j == i - 1)
                        return strs[i].length();
                }
            }            
        }
        return -1;
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
    
    Set<String> getDuplicates(String[] strs)
    {
        Set<String> seen = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();
        
        for (String str : strs)
        {
            if (!seen.add(str))
            {
                duplicates.add(str);
            }
        }
        return duplicates;
    }
}
