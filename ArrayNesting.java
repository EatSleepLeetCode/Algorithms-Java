
public class ArrayNesting 
{
    public int arrayNesting(int[] nums) 
    {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                int start = nums[i];                
                int count = 0;
                
                do
                {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                } while (start != nums[i]);
                
                max = Math.max(max, count);
            }                        
        }        
        return max;
    } 
}
