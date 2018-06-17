import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray 
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++)
        {
            if (nums[Math.abs(nums[i]) - 1] < 0)
                result.add(Math.abs(nums[i]));
            else
                nums[Math.abs(nums[i]) - 1] *= -1;
        }
        
        return result;
    }
}
