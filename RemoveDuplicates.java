import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates 
{
    public String removeDuplicateLetters(String s) 
    {
        int n = s.length();
        if(n < 2) return s;
        
        Map<Character, Integer> lastPosMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i < n; i++)
        {
            lastPosMap.put(s.charAt(i), i);
        }
        
        char[] result = new char[lastPosMap.size()];
        int resultLen = result.length;
        
        int left = 0;
        int right = findMinLastPos(lastPosMap);
        
        for(int i = 0; i < resultLen; i++)
        {
            char minChar = 'z' + 1;
            
            for(int j = left; j <= right; j++)      //Notice: j <= right
            {
                char ch = s.charAt(j);
                if(lastPosMap.containsKey(ch) && ch < minChar)
                {
                    minChar = ch;
                    left = j + 1;
                }
            }
            
            result[i] = minChar;
            
            if(i == resultLen - 1)
                break;	
            
            lastPosMap.remove(minChar);
            right = findMinLastPos(lastPosMap);
        }
        return new String(result);
    }
    
    int findMinLastPos(Map<Character, Integer> lastPosMap)
    {
        int min = Integer.MAX_VALUE;
        
        for(Integer pos : lastPosMap.values())
        {
            min = Math.min(min, pos);
        }

        return min;
    }
    
    public static void main(String[] args)
    {
    	RemoveDuplicates obj = new RemoveDuplicates();
    	System.out.println(obj.removeDuplicateLetters("abczabbcc"));
    }
}
