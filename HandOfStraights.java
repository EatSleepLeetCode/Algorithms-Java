import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights 
{
    public boolean isNStraightHand(int[] hand, int W) 
    {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (int card : hand)
        {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        for (int card : map.keySet())
        {
            int freq = map.get(card);
            
            if (freq <= 0)
                continue;
            
            for (int i = W - 1; i >= 0; i --)
            {
                if (map.getOrDefault(card + i, 0) < freq)
                {
                    return false;
                }
                map.put(card + i, map.get(card + i) - freq);
            }
        }
        return true;
    }
    
	public static void main(String[] args) 
	{
		HandOfStraights obj = new HandOfStraights();
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
		System.out.println(obj.isNStraightHand(new int[] {1,2,3,4,5,6}, 2));
	}
}
