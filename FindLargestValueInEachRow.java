import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachRow 
{
    public List<Integer> largestValues(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        
        if (root == null)
            return result;
        
        queue.offer(root);
        
        while (!queue.isEmpty())
        {
            int currSize = queue.size();
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < currSize; i++)
            {
                TreeNode curr = queue.poll();
                
                max = Math.max(max, curr.val);
                
                if (curr.left != null)
                    queue.offer(curr.left);
                
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            result.add(max);
        }
        
        return result;
    }
}
