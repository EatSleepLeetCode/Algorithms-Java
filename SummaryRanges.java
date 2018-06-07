import java.util.ArrayList;
import java.util.List;

public class SummaryRanges 
{
	public List<String> summaryRanges(int[] nums) 
    {
        List<String> result = new ArrayList<String>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
        {
            int num = nums[i];
            
            while(i < n - 1 && nums[i] + 1== nums[i + 1])
            {
                i++;
            }
            
            if(num != nums[i])
            {
                result.add(num + "->" + nums[i]);
            }
            else
            {
                result.add(num + "");
            }
        }
        
        return result;
    }
    
	public static void main(String[] args) 
	{
		SummaryRanges obj = new SummaryRanges();
		int[] nums = new int[] {-2147483648,-2147483647,2147483647};
		obj.summaryRanges(nums);
	}

}
