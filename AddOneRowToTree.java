import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree 
{
    public TreeNode addOneRow(TreeNode root, int v, int d) 
    {
        if (root == null) return root;
        if (d == 1)
        {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();        
        queue.offer(root);                            //Node for depth 1 is in queue
        
        for (int depth = 2; depth <= d - 1; depth++)  //Nodes for depth 2 to d - 1 are added here
        {            
            int currSize = queue.size();
            
            for (int i = 0; i < currSize; i++)
            {
                TreeNode curr = queue.poll();
                
                if (curr.left != null) queue.offer(curr.left);                
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        while (!queue.isEmpty())
        {                    
            TreeNode curr = queue.poll();
            TreeNode newNode = new TreeNode(v);
            newNode.left = curr.left;
            curr.left = newNode;
            
            newNode = new TreeNode(v);
            newNode.right = curr.right;
            curr.right = newNode;            
        }
        return root;
    }
}
