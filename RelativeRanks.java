class RelativeRanks
{
    public String[] findRelativeRanks(int[] nums) 
    {
        int n = nums.length;
        Integer[] index = new Integer[n];       //Important - it has to be Integer to use lambda
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++)
            index[i] = i;
        
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        for (int i = 0; i < n; i++)
        {
            if (i == 0)
                result[index[i]] = "Gold Medal";
            else if (i == 1)
                result[index[i]] = "Silver Medal";
            else if (i == 2)
                result[index[i]] = "Bronze Medal";
            else
                result[index[i]] = i + 1 + "";
        }
        return result;
    }
}
