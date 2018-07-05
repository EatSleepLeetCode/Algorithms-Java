class LongestHarmoniousSubsequence
{
    //Solution 1 - TLE (Using all possible sub-sequences)
    public int findLHS1(int[] nums) 
    {
        int n = nums.length;
        int result = 0;
        
        //if there are 3 elems in nums, we will run loop from 0 to 7
        for (int i = 0; i < (1 << n); i++)  
        {
            int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++)
            {
                //here we do & for each of the 3 bits and whatever is 1 is considered
                if ((i & (1 << j)) != 0)     
                {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    count++;
                }
            }
            if (max - min == 1)
                result = Math.max(result, count);
        }
        return result;
    }

    //Solution 2 - Using HashMap
    public int findLHS(int[] nums) 
    {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();        
        int result = 0;
        
        for (int i = 0; i < n; i++)
        {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int key : freqMap.keySet())
        {
            if (freqMap.containsKey(key + 1))
            {
                result = Math.max(result, freqMap.get(key) + freqMap.get(key + 1));
            }
        }
        return result;
    }
}
