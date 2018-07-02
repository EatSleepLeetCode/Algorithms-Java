class FindModeInBinarySearchTree
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
