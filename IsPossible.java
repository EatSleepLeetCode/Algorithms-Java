import java.util.HashMap;
import java.util.Map;

public class IsPossible 
{
    public boolean isPossible(int[] nums) 
    {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> tails = new HashMap<Integer, Integer>();
        
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        for (int num : nums)
        {
            if (freqMap.get(num) == 0) 
            {
                continue;
            }
            else if (tails.getOrDefault(num - 1, 0) > 0)
            {
                tails.put(num - 1, tails.get(num - 1) - 1);
                tails.put(num, tails.getOrDefault(num, 0) + 1);
            }
            else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0)
            {
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                tails.put(num + 2, tails.getOrDefault(num + 2, 0) + 1);
            }
            else
            {
                return false;
            }
            
            freqMap.put(num, freqMap.get(num) - 1);
        }
        
        return true;
    }
}
