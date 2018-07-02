// Solution - 1 (Fast)
class FindModeInBinarySearchTree
{
    Integer prev = null;
    int count = 1;
    int max = 0;
    
    public int[] findMode(TreeNode root) 
    {
        if (root == null) return new int[0];
        
        List<Integer> resultList = new ArrayList<Integer>();        
        traverse(root, resultList);
        
        int[] result = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++)
        {
            result[i] = resultList.get(i);
        }
        return result;
    }
    
    void traverse(TreeNode root, List<Integer> resultList)
    {
        if (root == null)
            return;
        
        traverse(root.left, resultList);
        
        if (prev != null)
        {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        
        if (count > max)
        {
            max = count;
            resultList.clear();
            resultList.add(root.val);
        }
        else if (count == max)
        {
            resultList.add(root.val);
        }
        
        prev = root.val;
        traverse(root.right, resultList);
    }
}

// Solution - 2 (Slow) Uses Map
class FindModeInBinarySearchTree1
{
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    int max = 0;
    
    public int[] findMode(TreeNode root) 
    {
        List<Integer> resultList = new ArrayList<Integer>();        
        inOrder(root);
        
        for (int key : freqMap.keySet())
        {
            if (freqMap.get(key) == max)
            {
                resultList.add(key);
            }
        }
        
        int[] result = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++)
        {
            result[i] = resultList.get(i);
        }
        return result;
    }
    
    void inOrder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.isEmpty())
        {
            if (root != null)
            {
                stack.push(root);
                freqMap.put(root.val, freqMap.getOrDefault(root.val, 0) + 1);
                max = Math.max(max, freqMap.get(root.val));
                root = root.left;
            }
            else
            {
                TreeNode curr = stack.pop();
                root = curr.right;
            }
        }            
    }
}
