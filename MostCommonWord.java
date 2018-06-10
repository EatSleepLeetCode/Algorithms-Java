import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord 
{
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        int n = paragraph.length();
        Map<String, Integer> freqMap = new HashMap<String, Integer>();
        Set<String> banSet = new HashSet<String>();
        int i = 0;
        int maxFreq = 0;
        String result = "";
        
        for (String word : banned)
        {
            banSet.add(word);
        }
        
        while (i < n)
        {
            if (Character.isLetter(paragraph.charAt(i)))
            {
                StringBuilder sb = new StringBuilder();
                
                while (i < n && Character.isLetter(paragraph.charAt(i)))
                {
                    sb.append(Character.toLowerCase(paragraph.charAt(i)));
                    i++;
                }
                String word = sb.toString();
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
            else
            {
                i++;
            }
        }
        
        for (Map.Entry<String, Integer> entry : freqMap.entrySet())
        {
            if (!banSet.contains(entry.getKey()) && maxFreq < entry.getValue())
            {
                maxFreq = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
