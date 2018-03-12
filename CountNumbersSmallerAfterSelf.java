import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNumbersSmallerAfterSelf 
{
    public List<Integer> countSmaller(int[] nums) 
    {        
        int n = nums.length;
        if(n == 0)
            return new ArrayList<Integer>();
        
        //Created Integer type array bcoz we can't do Arrays.asList(result)
        //if result is of type 'int' instead of 'Integer' because output
        //is expected in List<Integer> format.
        Integer[] result = new Integer[n];      
        List<Integer> sorted = new ArrayList<Integer>();
        
        for(int i = n - 1; i >= 0; i--)
        {
            result[i] = findIndex(sorted, nums[i]);
            sorted.add(result[i], nums[i]);
        }

        return Arrays.asList(result);
    }
    
    int findIndex(List<Integer> sorted, int target)
    {
        if(sorted.size() == 0)
            return 0;
        int left = 0;
        int right = sorted.size() - 1;
        
        if(target <= sorted.get(left))
            return 0;
        
        if(target > sorted.get(right))
            return right + 1;
        
        while(left < right)
        {
            int mid = (right + left) / 2;
            if(sorted.get(mid) < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        
        if(target <= sorted.get(left))
            return left;
        else
            return right;
    }
	public static void main(String[] args) 
	{
		CountNumbersSmallerAfterSelf obj = new CountNumbersSmallerAfterSelf();
		System.out.println(obj.countSmaller(new int[] {5, 2, 6, 1}));
	}
}