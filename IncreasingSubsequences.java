import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences 
{
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(nums, 0, result, curr);
        return new ArrayList<List<Integer>>(result);        //Set<List> to List<List>
    }
    
    void helper(int[] nums, int start, Set<List<Integer>> result, List<Integer> curr)
    {
        if (curr.size() > 1)
            result.add(new ArrayList<Integer>(curr));
        
        for (int i = start; i < nums.length; i++)
        {
            if (curr.size() == 0 || nums[i] >= curr.get(curr.size() - 1))
            {
                curr.add(nums[i]);
                helper(nums, i + 1, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
