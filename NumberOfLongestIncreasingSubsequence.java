import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence 
{
    public int findNumberOfLIS(int[] nums) 
    {
        int n = nums.length;
        int[] lis = new int[n];
        int[] count = new int[n];
        int maxLen = 1;
        int result = 0;
        
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    if(lis[i] < lis[j] + 1)
                    {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j]; 
                    }
                    else if(lis[i] == lis[j] + 1)
                    {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lis[i]);            
        }
        
        for(int i = 0; i < n; i++)
        {
            if(lis[i] == maxLen)
            {
                result += count[i];
            }
        }
        return result;
    }

	public static void main(String[] args) 
	{
		NumberOfLongestIncreasingSubsequence obj = new NumberOfLongestIncreasingSubsequence();
		System.out.println(obj.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
	}
}
