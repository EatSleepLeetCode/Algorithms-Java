import java.util.Arrays;

public class MaxIncreaseKeepSkyline 
{
    public int maxIncreaseKeepingSkyline(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] maxLeftOrRight = new int[rows];
        int[] maxTopOrBottom = new int[cols];
        
        Arrays.fill(maxLeftOrRight, Integer.MIN_VALUE);
        Arrays.fill(maxTopOrBottom, Integer.MIN_VALUE);
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                maxLeftOrRight[i] = Math.max(maxLeftOrRight[i], grid[i][j]);
                maxTopOrBottom[j] = Math.max(maxTopOrBottom[j], grid[i][j]);
            }
        }
        
        int result = 0;
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                int min = Math.min(maxLeftOrRight[i], maxTopOrBottom[j]);
                
                if(grid[i][j] < min)
                    result += min - grid[i][j];
            }
        }
        return result;
    }
    
	public static void main(String[] args) 
	{
		MaxIncreaseKeepSkyline obj = new MaxIncreaseKeepSkyline();
		System.out.println(obj.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
	}
}
