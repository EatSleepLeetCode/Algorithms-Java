import java.util.HashMap;
import java.util.Map;

public class CustomSortString 
{
    public String customSortString(String S, String T) 
    {
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i < T.length(); i++)
        {
            char ch = T.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
            
        StringBuilder result = new StringBuilder();
        
        for(int i = 0 ; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            
            if(tMap.containsKey(ch))
            {
                int n = tMap.get(ch);
                for(int j = 0; j < n; j++)
                {
                    result.append(ch);
                }
                
                tMap.remove(ch);    //remove this character because we have already used it
            }
        }
        
        for(Map.Entry<Character, Integer> entry : tMap.entrySet())
        {
            char ch = entry.getKey();
            int n = tMap.get(ch);
            for(int i = 0; i < n; i++)
            {
                result.append(ch);
            }
        }  
        
        return result.toString();
	}
	public static void main(String[] args) 
	{
		CustomSortString obj = new CustomSortString();
		System.out.println(obj.customSortString("cab", "abcd"));
	}
}
