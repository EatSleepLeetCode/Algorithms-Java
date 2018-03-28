import java.util.ArrayList;
import java.util.List;

public class MissingRanges 
{
	List<String> findMissingRanges(int[] nums, int lower, int upper)
	{
		List<String> result = new ArrayList<String>();
		int n = nums.length;
		if(n == 0)
		{
			addRange(result, lower, upper);
			return result;
		}
		
		if(lower > nums[0])
			addRange(result, lower, nums[0] - 1);
		
		for(int i = 1; i < n; i++)
		{
			if(nums[i] - nums[i - 1] != 1)
				addRange(result, nums[i - 1] + 1, nums[i] - 1);
		}
		
		if(nums[n - 1] < upper)
			addRange(result, nums[n - 1] + 1, upper);
		
		return result;
	}
	
	void addRange(List<String> result, int start, int end)
	{
		if(start == end)
			result.add(start + "");
		else
			result.add(start + "->" + end);
	}
	
	public static void main(String[] args) 
	{
		MissingRanges obj = new MissingRanges();
		System.out.println(obj.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
	}
}
