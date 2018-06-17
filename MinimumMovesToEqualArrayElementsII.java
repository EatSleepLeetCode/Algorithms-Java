import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII 
{
    public int minMoves2(int[] nums) 
    {
        int n = nums.length;
        int median = 0;
        int count = 0;
        
        Arrays.sort(nums);
        median = nums[n / 2];
        
        for (int i = 0; i < n; i++)
        {
            count += Math.abs(nums[i] - median);
        }
        
        return count;
    }
}
