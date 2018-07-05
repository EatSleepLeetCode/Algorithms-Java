class NonDecreasingArray 
{
    //Solution 1 - Modify input
    public boolean checkPossibility1(int[] nums) 
    {
        int modified = 0;
        
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i - 1] > nums[i])
            {
                if (modified > 0) return false;
                modified++;
                
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];              //lower nums[i - 1]
                else
                    nums[i] = nums[i - 1];              //raise nums[i]
            }
        }
        return true;
    }
    
    //Solution - Don't modify input
    public boolean checkPossibility(int[] nums) 
    {
        int modified = 0;
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++)
        {
            if (prev > nums[i])
            {
                if (modified > 0) return false;
                modified++;

                if (i - 2 >= 0 && nums[i - 2] > nums[i])
                    continue;                
            }
            prev = nums[i];
        }
        return true;
    }
}
