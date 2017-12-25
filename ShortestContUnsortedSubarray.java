
public class ShortestContUnsortedSubarray 
{
	 public int findUnsortedSubarray(int[] nums) 
	 {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       
        for (int i = 1; i < n; i++) 
        {
            if (nums[i - 1] > nums[i])
            {
                min = Math.min(min, nums[i]);
            }
        }

       for (int i = n - 1; i > 0; i--) 
       {
            if (nums[i - 1] > nums[i])
            {
                max = Math.max(max, nums[i - 1]);
            }
        }
       
        int left = -1;
        int right = -1;
       
        for (left = 0; left < n; left++) 
        {
            if (min < nums[left])
            {
                break;
            }
        }
       
        for (right = n - 1; right >= 0; right--) 
        {
            if (max > nums[right])
            {
                break;
            }
        }
       
        return right - left < 0 ? 0 : right - left + 1;
    }
	 
	public static void main(String[] args) 
	{
		ShortestContUnsortedSubarray obj = new ShortestContUnsortedSubarray();
		int[] nums = new int[] {1,3,5,4,2};
		System.out.println(obj.findUnsortedSubarray(nums));
	}

}
