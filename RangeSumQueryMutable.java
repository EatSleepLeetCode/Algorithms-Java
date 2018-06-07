class RangeSumQueryMutable 
{
	int[] nums;
	int[] BIT;
	int n;
	
	public RangeSumQueryMutable(int[] arr)
	{
		nums = arr;
		n = nums.length;
		BIT = new int[n + 1];
		
		for(int i = 0; i < n; i++)
		{
			init(i, nums[i]);
		}
	}
	
	void init(int i, int val)
	{
		i++;
		
		while(i <= n)
		{
			BIT[i] += val;
			i = i + (i & -i);
		}
	}
	
	void update(int i, int val)
	{
		int diff = val - nums[i];
		nums[i] = val;
		init(i, diff);
	}
	
	int getSum(int i)
	{
		i++;
		
		int sum = 0;
		 while(i > 0)
		 {
			 sum += BIT[i];
			 i = i - (i & -i);
		 }
		return sum;
	}
	
	int sumRange(int i, int j)
	{
		return getSum(j) -  getSum(i - 1);
	}
	
    public static void main(String[] args) 
	{
       	int[] nums = new int[] {1,4,5,6,3,2,7};
       	
    	RangeSumQueryMutable obj = new RangeSumQueryMutable(nums);
    	
    	System.out.println(obj.sumRange(0, 6));
	}

}
