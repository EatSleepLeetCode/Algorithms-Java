import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumRootToLeafNumbers 
{
    //Solution 1 
    public int sumNumbers1(TreeNode root) 
    {
        if(root == null)
            return 0;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(result, curr, root);
        
        return findSum(result);
    }
    
    void helper(List<List<Integer>> result, List<Integer> curr, TreeNode node)
    {
        if(node == null)
        {
            return;
        }
        
        curr.add(node.val);
        
        if(node.left == null && node.right == null)
        {
            result.add(new ArrayList<Integer>(curr));            
        }
        else
        {
            helper(result, curr, node.left);
            helper(result, curr, node.right);
        }
        
        curr.remove(curr.size() - 1);
    }
    
    int findSum(List<List<Integer>> result)
    {
        int resultSize = result.size();
        int sum = 0;
        for(int i = 0; i < resultSize; i++)
        {
            int subResultSize = result.get(i).size();
            int num = 0;
            for(int j = 0; j < subResultSize; j++)
            {
                num = num * 10 + result.get(i).get(j);
            }
            sum += num;
        }
        return sum;
    }
    
    //Solution 2
    public int sumNumbers2(TreeNode root) 
    {
        return helper(root,  0);
    }
    
    int helper(TreeNode node, int sum)
    {
        if(node == null)
            return 0;
        
        sum = sum * 10 + node.val;
        
        if(node.left == null && node.right == null)
            return sum;
        
        return helper(node.left, sum) + helper(node.right, sum);
    }
    
    //Solution - 3
    public int sumNumbers3(TreeNode root) 
    {
        if(root == null)
            return 0;
        int result = 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> sum = new LinkedList<Integer>();
        queue.offer(root);
        sum.offer(root.val);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();            
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = queue.poll();
                int currSum = sum.poll();
                
                if(curr.left != null)
                {
                    queue.offer(curr.left);
                    sum.offer(currSum * 10 + curr.left.val);
                }
                
                if(curr.right != null)
                {
                    queue.offer(curr.right);
                    sum.offer(currSum * 10 + curr.right.val);
                }
                
                if(curr.left == null && curr.right == null)
                {
                    result = result + currSum;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
