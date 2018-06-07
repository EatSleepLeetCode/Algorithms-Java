import java.util.Arrays;

public class BottomUpDP 
{
	int findMinSumBottomUpDP(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int j = 1; j < cols; j++)
		{
			grid[0][j] += grid[0][j - 1];
		}

		for(int i = 1; i < rows; i++)
		{
			grid[i][0] += grid[i - 1][0];
		}
		
		for(int i = 1; i < rows; i++)
		{
			for(int j = 1; j < cols; j++)
			{
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);  
			}
		}
		
		return grid[rows - 1][cols - 1];	
	}

	
	public static void main(String[] args) 
	{
		BottomUpDP obj = new BottomUpDP();
		
		int[][] grid = new int[][]{
									{31, 100, 65, 12, 18},
									{10, 13, 47, 157, 6},
									{100, 113, 174, 11, 33},
									{88, 124, 41, 20, 140},
									{99, 32, 111, 41, 20}};

		System.out.println(obj.findMinSumBottomUpDP(grid));
	}

}
