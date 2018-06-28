public class CanPartitionKSubsets
{
    public boolean canPartitionKSubsets(int[] nums, int k) 
    {
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (k <= 0 || sum % k != 0) 
            return false;
        
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, sum / k);
    }
    
    boolean canPartition(int[] nums, boolean[] visited, int start, int k, int currSum, int target)
    {
        if (k == 1) 
            return true;
        
        if (currSum == target)
            return canPartition(nums, visited, 0, k - 1, 0, target);
        
        for (int i = start; i < nums.length; i++)
        {
            if (visited[i])
                continue;
            
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, currSum + nums[i], target))
                return true;
            visited[i] = false;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        CanPartitionKSubsets obj = new CanPartitionKSubsets();
        System.out.println(obj.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
