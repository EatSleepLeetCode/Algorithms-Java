import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK 
{
	public int subarraySum(int[] nums, int sum) 
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int currSum = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            currSum += nums[i];
            
            if(currSum == sum)
            {
                count++;
            }
            
            if(map.containsKey(currSum - sum))
            {
                count += map.get(currSum - sum);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
    
	public static void main(String[] args) 
	{
		SubarraySumEqualsK obj = new SubarraySumEqualsK();
		int[] nums = new int[] {1,1,1};
		System.out.println(obj.subarraySum(nums, 2));
	}
}
