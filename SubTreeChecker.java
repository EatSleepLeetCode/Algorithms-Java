
public class SubTreeChecker 
{
	//Solution 1
    public boolean isSubtree1(TreeNode s, TreeNode t) 
    {
        String preOrderS = "";
        String preOrderT = "";
        
        preOrderS = preOrder(s, true);
        preOrderT = preOrder(t, false);
        
        return preOrderS.indexOf(preOrderT) >= 0;
    }
    
    String preOrder(TreeNode node, boolean isLeft)
    {
        if(node == null)
        {
            return isLeft ? "lNull" : "rNull";
        }
        
        return "#" + node.val + preOrder(node.left, true) + preOrder(node.right, false);
    }
	
	//Solution 2
    public boolean isSubtree2(TreeNode s, TreeNode t) 
    {
        StringBuilder preOrderS = new StringBuilder();
        StringBuilder preOrderT = new StringBuilder();
        
        preOrder(s, true, preOrderS);
        preOrder(t, true, preOrderT);
        
        return preOrderS.toString().indexOf(preOrderT.toString()) >= 0;
    }
    
    void preOrder(TreeNode node, boolean isLeft, StringBuilder preOrderResult)
    {
        if(node == null)
        {
            preOrderResult.append(isLeft ? "lNull" : "rNull");
            return;
        }
        
        preOrderResult.append("#" + node.val);
        preOrder(node.left, true, preOrderResult);
        preOrder(node.right, false, preOrderResult);
    }
	
    //Solution 3
    public boolean isSubtree(TreeNode s, TreeNode t) 
    {
        //Base case - since this function is called recursively
        if(s == null)
            return false;
        
        if(isSameTree(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTree(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null)
            return true;
        
        if(node1 != null && node2 != null && node1.val == node2.val)
            return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        else
            return false;
    }
    
	public static void main(String[] args) 
	{
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right= new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right= new TreeNode(2);
		s.left.left.left = new TreeNode(0);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		
		SubTreeChecker obj = new SubTreeChecker();
		obj.isSubtree(s, t);
	}

}
