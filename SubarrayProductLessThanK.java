public class SubarrayProductLessThanK
{
    public int numSubarrayProductLessThanK(int[] nums, int k) 
    {
        int n = nums.length;
        int left = 0, right = 0, result = 0, currProd = 1;
        if (k <= 1) return 0;
        
        while (right < n)
        {
            currProd *= nums[right];
            right++;            
            
            while (currProd >= k)
            {
                currProd = (int) (currProd / nums[left]);
                left++;
            }
            
            result += right - left;
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        SubarrayProductLessThanK obj = new SubarrayProductLessThanK();
        System.out.println(obj.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }
}
