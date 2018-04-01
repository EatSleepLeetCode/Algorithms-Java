import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords 
{
    public int expressiveWords(String S, String[] words) 
    {
        if(words.length == 0 || S.length() == 0)
            return 0;
        List<Integer> sCounts = new ArrayList<Integer>();
        String sKey = compress(S, sCounts);
        
        int count = 0;
        for(String word : words)
        {
            List<Integer> wCounts = new ArrayList<Integer>();
            String wKey = compress(word, wCounts);
            int wLength = wKey.length();
            
            if(!wKey.equals(sKey))
            	continue;
            int i = 0;
    		for(i = 0; i < wLength; i++)
    		{
    			int sCount = sCounts.get(i);
    			int wCount = wCounts.get(i);
    			if((sCount < 3 && sCount != wCount) || sCount < wCount)
    				break;        				
    		}
    		if(i == wLength)
    			count++;
        }
        return count;
    }

    String compress(String S, List<Integer> counts)
    {
        int n = S.length();
        String key = "";
        int count = 0;
        int i = 0;
        while(i < n)
        {
            char ch = S.charAt(i);
            count = 0;
            
            while(i < n && ch == S.charAt(i))
            {
                count++;
                i++;
            }
            
        	key = key + ch;
        	counts.add(count);
        }
        return key;
    }
	public static void main(String[] args) 
	{
		ExpressiveWords obj = new ExpressiveWords();
		System.out.println(obj.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"}));
	}

}
