import java.util.Arrays;

public class MatchsticksToSquare 
{
    public boolean makesquare(int[] nums) 
    {
        int n = nums.length;
        int sum = 0, target = 0;
        int[] sides = new int[4];
        
        if (n < 4) return false;
        
        for (int i = 0; i < n; i++)
        {
            sum += nums[i];
        }
        
        if (sum % 4 != 0) return false;
        
        target = sum / 4;
        
        Arrays.sort(nums);
        reverse(nums);                      //To make it sorted in descending order
        
        return dfs(nums, sides, target, 0);
    }
    
    boolean dfs(int[] nums, int[] sides, int target, int index)
    {
        if (index == nums.length)
        {
            if (sides[0] == target && sides[1] == target && sides[2] == target)
                return true;
            else
                return false;
        }
        
        for (int i = 0; i < 4; i++)
        {
            if (sides[i] + nums[index] > target)
                continue;
            
            sides[i] += nums[index];
            
            if (dfs(nums, sides, target, index + 1))
                return true;
            
            sides[i] -= nums[index];
        }
        return false;
    }
    
    void reverse(int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;
        int backUp = 0;
        
        while (left < right)
        {
            backUp = nums[left];
            nums[left] = nums[right];
            nums[right] = backUp;
            left++;
            right--;
        }
    }
}
