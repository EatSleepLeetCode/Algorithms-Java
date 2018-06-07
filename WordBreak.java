import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordBreak 
{
	public boolean wordBreak(String s, List<String> wordDict) 
    {
        int n = s.length();
        
        if(n == 0)
        {
            return false;
        }
       
        boolean[] found = new boolean[n+1];
        
        found[0] = true;
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(found[j] && wordDict.contains(s.substring(j,i)))
                {
                    found[i] = true;
                    break;
                }
            }
        }
       
        return found[n];
    }
    
    public static void main(String[] args)
    {
    	WordBreak obj = new WordBreak();
    	List<String> wordDict = new ArrayList<String>(Arrays.asList("leet", "code", "codes", "leets"));
    	System.out.println(obj.wordBreak("leetcode", wordDict));
    }
}