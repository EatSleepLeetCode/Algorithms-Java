import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII 
{
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(k, n, 0, 1, curr, result);
        return result;
    }
    
    void helper(int k, int n, int sum, int index, List<Integer> curr, List<List<Integer>> result)
    {
        if (curr.size() == k)
        {
            if (sum == n)
                result.add(new ArrayList<Integer>(curr));
            
            return;
        }
        
        for (int i = index; i <= 9; i++)
        {
            if (sum + i > n)
                continue;
            
            if (curr.contains(i))
                continue;
            
            curr.add(i);
            helper(k, n , sum + i, i + 1, curr, result);
            curr.remove(curr.size() - 1);            
        }
    }
}
