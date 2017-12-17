import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum 
{
	public boolean checkSubarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        
        //Map stores <sum % k, index> pair 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //Initialize for sum = 0 and index = - 1
        map.put(0, -1);
        
        int sum = 0;
        
        for(int i = 0; i < n; i++)
        {
            sum += nums[i];
            
            if(k != 0)
            {
                sum %= k;
            }
            
            if(map.containsKey(sum))
            {
                if(i - map.get(sum) > 1)    //check if length is at least 2
                    return true;
            }
            else
            {
                map.put(sum, i);
            }  
        }
        return false;
    }
 
	public static void main(String[] args) 
	{
		ContinuousSubArraySum obj = new ContinuousSubArraySum();
		int[] nums = new int[] {23, 0, 3, 1, 8};
		System.out.println(obj.checkSubarraySum(nums, 6));

	}

}
