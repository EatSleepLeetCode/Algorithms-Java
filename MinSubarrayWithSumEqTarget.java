
public class MinSubarrayWithSumEqTarget 
{
    public int minSubArrayLen(int target, int[] nums) 
    {
        int n = nums.length;
        int currSum = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        
        while(right < n)
        {
            while(right < n && currSum < target)
            {
                currSum += nums[right];
                right++;
            }
            
            while(left <= right && currSum > target)
            {
                currSum -= nums[left];
                left++;
            }
            
            while(left <= right && currSum == target)
            {
                min = Math.min(min, right - left);
                currSum -= nums[left];
                left++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
	public static void main(String[] args) 
	{
		MinSubarrayWithSumEqTarget obj = new MinSubarrayWithSumEqTarget();
		System.out.println(obj.minSubArrayLen(23, new int[] {15,2,4,8,9,5,10,23}));
		
	}
}
