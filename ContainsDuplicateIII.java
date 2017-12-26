import java.util.HashMap;
import java.util.Map;

//Given an array of integers, find out whether there are two distinct indices i and j 
//in the array such that the absolute difference between nums[i] and nums[j] is at most
//t and the absolute difference between i and j is at most k.
public class ContainsDuplicateIII 
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
        //t == 0 is OK, but k == 0 isn't because i & j are distinct        
        if(t < 0 || k < 1)  
            return false;
        
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        
        for(int i = 0; i < n; i++)
        {
            //Integer.MAX_VALUE is added to offset the value in order to get correct result 
            //in cases e.g. {-3, 3}, 2 , 4. Because both -3 and 3 will lead to bucket being 0
            long remappedNum = (long) nums[i] + Integer.MAX_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            
            if(map.containsKey(bucket) ||
               (map.containsKey(bucket - 1) && remappedNum - map.get (bucket - 1) <= t) ||
               (map.containsKey(bucket + 1) && map.get (bucket + 1) - remappedNum <= t))
                return true;
            
            if(map.entrySet().size() >= k)
            {
                long lastBucket = ((long) nums[i - k] + Integer.MAX_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
	public static void main(String[] args) 
	{
		ContainsDuplicateIII obj = new ContainsDuplicateIII();
		int[] nums = new int[] {1, 6, 3, 12, 10};
		obj .containsNearbyAlmostDuplicate(nums, 3, 2);
		
		nums = new int[] {-3, 3};
		obj .containsNearbyAlmostDuplicate(nums, 2, 4);
		
	}
}
