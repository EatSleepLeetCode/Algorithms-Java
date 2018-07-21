class SubtreeWithAllDeepest 
{
    public TreeNode subtreeWithAllDeepest(TreeNode root) 
    {
        if (root == null) return null;
        
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        depth(root, map);
        return dfs(root, map);
    }
    
    int depth(TreeNode root, Map<TreeNode, Integer> map)
    {
        if (root == null) return 0;        
        if (map.containsKey(root)) return map.get(root);
        int max = 1 + Math.max(depth(root.left, map), depth(root.right, map));
        map.put(root, max);
        return max;
    }
    
    TreeNode dfs(TreeNode root, Map<TreeNode, Integer> map)
    {
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        
        if (left == right) return root;
        if (left > right) return dfs(root.left, map);
        return dfs(root.right, map);        
    }
}
