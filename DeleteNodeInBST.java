
public class DeleteNodeInBST 
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root == null)
            return null;
        
        if(key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if(root.left == null || root.right == null)
            {
                TreeNode temp = null;

                if(root.left != null)
                    temp = root.left;
                
                else if(root.right != null)
                    temp = root.right;
                
                if(temp == null)
                    root = null;
                else
                    root = temp;
            }
            else
            {
                TreeNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }
    
    TreeNode minValueNode(TreeNode root)
    {
        TreeNode curr = root;
        
        while(curr.left != null)
        {
            curr = curr.left;
        }
        return curr;
    }
    
	public static void main(String[] args) 
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right= new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right= new TreeNode(4);
		root.right.right= new TreeNode(7);
		
		DeleteNodeInBST obj = new DeleteNodeInBST();
		obj.deleteNode(root, 3);
	}
}
