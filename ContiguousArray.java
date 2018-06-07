import java.util.HashMap;
import java.util.Map;

public class ContiguousArray 
{
	 public int findMaxLength(int[] nums) 
    {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++)
        {
            sum += nums[i] == 1 ? 1: -1;
            
            if(map.containsKey(sum))
            {
                max = Math.max(max, i - map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) 
	{
		ContiguousArray obj = new ContiguousArray();
		int[] nums = new int[] {0,0,1,1,0,1,0};
		System.out.println(obj.findMaxLength(nums));
	}

}
