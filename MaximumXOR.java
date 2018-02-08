import java.util.HashSet;
import java.util.Set;

public class MaximumXOR 
{
    public int findMaximumXOR(int[] nums) 
    {
        int mask = 0;
        int max = 0;
        
        /*The max is a record of the largest XOR we got so far. if it's 11100 at i = 2, it means 
        before we reach the last two bits, 11100 is the biggest XOR we have, and we're going to explore
        whether we can get another two '1's and put them into maxResult
        This is a greedy part, since we're looking for the largest XOR, we start 
        from the very beginning, aka, the 31st position of bits. */
        
        for(int i = 31; i >= 0; i--)
        {
            //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
            //for each iteration, we only care about the left parts
            
            mask = mask | (1 << i);
            
            Set<Integer> set = new HashSet<Integer>();
            
            for(int num : nums)
            {
                /*we only care about the left parts, for example, if i = 2, then we have
                {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}*/
                
                int leftPart = num & mask;
                set.add(leftPart);
            }
            
            // if i = 1 and before this iteration, the max we have now is 1100, my wish is the 
            //max will grow to 1110, so I will try to find a candidate which can give me the greedyTry
            
            int greedyMax = max | (1 << i);
            
            for(int leftPart : set)
            {
                //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPart
                // If we hope the formula a ^ b = c to be valid, then we need the b, 
                // and to get b, we need a ^ c, if a ^ c existed in our set, then we're good to go
                
                int anotherNum = greedyMax ^ leftPart; 
                if(set.contains(anotherNum))
                {
                    max = greedyMax;
                    break;
                }
            }
        }
        return max;
    }

	public static void main(String[] args) 
	{
		MaximumXOR obj = new MaximumXOR();
		System.out.println(obj.findMaximumXOR(new int[] {1,2,3,4}));
	}
}
