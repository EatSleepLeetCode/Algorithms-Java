import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree 
{
    class Params
    {
        TreeNode root;
        int i;
        int l;
        int r;
        Params(TreeNode n, int ii, int ll, int rr)
        {
            root = n;
            i = ii;
            l = ll;
            r = rr;
        }        
    }
    
    public List<List<String>> printTree(TreeNode root) 
    {
        int height = getHeight(root);
        String[][] result = new String[height][(int)Math.pow(2, height) - 1];
        for (String[] arr : result)
            Arrays.fill(arr, "");
        
        List<List<String>> ans = new ArrayList<List<String>>();
        fill(result, root, 0, 0, result[0].length);
        
        for (String[] arr : result)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    
    void fill(String[][] result, TreeNode root, int i, int l, int r)
    {
        Queue<Params> queue = new LinkedList<Params>();
        queue.add(new Params(root, 0, 0, result[0].length));
        
        while (!queue.isEmpty())
        {
            Params curr = queue.poll();
            result[curr.i][(curr.l + curr.r) / 2] = "" + curr.root.val;
            
            if (curr.root.left != null)
                queue.offer(new Params(curr.root.left, curr.i + 1, curr.l, (curr.l + curr.r) / 2));
        
            if (curr.root.right != null)
                queue.offer(new Params(curr.root.right, curr.i + 1, (curr.l + curr.r) / 2, curr.r));
        }
    }
    
    int getHeight(TreeNode root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
