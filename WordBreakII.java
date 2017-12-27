import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII 
{
	 public List<String> wordBreak(String s, List<String> wordDict) 
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, wordDict, map);
    }
    
    List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map)
    {
        if(map.containsKey(s))
            return map.get(s);
        
        List<String> result = new ArrayList<String>();
        
        if(s.length() == 0)
        {
            result.add("");
            return result;
        }
        
        for(String word : wordDict)
        {
            if(s.startsWith(word))
            {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                
                for(String sub : sublist)
                {
                    result.add(word + (sub == "" ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        return result;
    }
	
	public static void main(String[] args) 
	{		
		WordBreakII obj = new WordBreakII();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("dogs");
		obj.wordBreak("catsanddog", wordDict);
	}

}
