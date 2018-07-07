class FindShortestSubArray
{
    public int findShortestSubArray(int[] nums) 
    {
        int n = nums.length;
        int result = n;
        int degree = 0;
        
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        
        for (int i = 0; i < n; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i], new int[] {1, i, i});
            }
            else
            {
                int[] val = map.get(nums[i]);
                val[0]++;
                val[2] = i;
            }            
        }
        
        for (int[] value : map.values())
        {
            if (value[0] > degree)
            {
                degree = value[0];
                result = value[2] - value[1] + 1;
            }
            else if (value[0] == degree)
            {
                result = Math.min(result, value[2] - value[1] + 1);
            }
        }
        return result;
    }
}
