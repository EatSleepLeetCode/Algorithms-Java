import java.util.Stack;

public class RecoverBST 
{
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) 
    {
        traverseInOrder(root);
        
        int backup = first.val;                         //swap values and not nodes
        first.val = second.val;
        second.val = backup;
    }
    
    void traverseInOrder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty())
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                TreeNode curr = stack.pop();
                
                if (first == null && prev.val >= curr.val)
                    first = prev;                           //setting first to prev
                
                if (first != null && prev.val >= curr.val)
                    second = curr;                          //setting second to curr
                
                prev = curr;
                
                root = curr.right;
            }
        }
    }
    
	public static void main(String[] args) 
	{

	}
}
