import java.util.Arrays;

public class MinPathSum4Dir 
{
	int min = Integer.MAX_VALUE;
	
	int findMinSum(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		helper(grid, 0, 0, rows, cols, 0 ,visited);
		return min;
	}
	
	void helper(int[][] grid, int row, int col, int rows, int cols, int currSum, boolean[][] visited)
	{
		if(row == rows - 1 && col == cols - 1)
		{
			min = Math.min(min, currSum + grid[row][col]);
			return;
		}

		if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
			return;
		
		visited[row][col] = true;
	
		helper(grid, row + 1, col, rows, cols, currSum + grid[row][col], visited);
		helper(grid, row - 1, col, rows, cols, currSum + grid[row][col], visited);
		helper(grid, row, col + 1, rows, cols, currSum + grid[row][col], visited);
		helper(grid, row, col - 1, rows, cols, currSum + grid[row][col], visited);
		
		visited[row][col] = false;
	}
	
	/*
	 * Below DP approach won't work for this problem i.e. below program will not give correct result 
	 * 
	 * E.g. if the grid is as below:
	 * 
	 * 		31  100   65
	 *		10   13   47
	 *		99   41   20
	 *
	 * We have below cached values:
	 *		 -1  131  196
	 *		 41  144  243
	 *		140  181  201
	 * 
	 * Now, cache[1][1] is saying whoever reaches me, will need 144 i.e. cache[0][1] + grid[1][1] 
	 * i.e. 131 + 13 = 144.
	 *  
	 * However, that's the not correct because the lowest cost path form it to [0, 0] is 54 i.e.
	 * cache[1][0] + grid[1][1] = 41 + 13.
	 * 
	 * **********************************************************************************************
	 * Since the cache[1][1] will have stored the value 144 our code couldn't go in the direction
	 * of optimal result because cache[1][1] will have a value.  
	 * i.e. the change in the order of operations in the DFS (dir) loop will change the result,
	 * which is against the principle of DP.
	 * **********************************************************************************************
	 * 
	 * FYI - we used visited array to avoid infinite loop because we can go in 4 directions.
	 * However, if we could go in only 2 directions then we wouldn't need visited because
	 * we won't run into cycles.
	 */
	
	int findMinSumDP(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[][] cache = new int[rows][cols];
		
		for(int i = 0; i < rows; i++)
			Arrays.fill(cache[i], -1);
		
		return helperDP(grid, cache, visited, rows - 1, cols - 1, rows, cols);
	}
	
	int helperDP(int[][] matrix, int[][] cache, boolean [][] visited, int row, int col, int rows, int cols)
	{
		if(cache[row][col] != -1)
		{
			return cache[row][col];			
		}
		
		if(row == 0 && col == 0)
		{
			return matrix[row][col];
		}

		visited[row][col] = true;
		
		int cmin = Integer.MAX_VALUE;
		
//		for(int[] dir : new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}})	//We get 121 when use this order
		for(int[] dir : new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}})	//We get 201 when use this order
		{
			int incRow = dir[0];
			int incCol = dir[1];
			
			int updRow = row + incRow;
			int updCol = col + incCol;
			
			if(updRow < 0 || updRow >= rows || updCol < 0 || updCol >= cols || visited[updRow][updCol])
			{
				continue;
			}
			int sum = matrix[row][col] + helperDP(matrix, cache, visited, updRow, updCol, rows, cols);
			cmin =  Math.min(cmin, sum);
		}
		
		visited[row][col] = false;
		cache[row][col] = cmin;
		return cmin;
	}

	
	public static void main(String[] args) 
	{
		MinPathSum4Dir obj = new MinPathSum4Dir();
									
		int[][] grid = new int[][]{
			{31, 100, 65},
			{10, 13, 47},
			{99, 41, 20}};
									
									
		System.out.println(obj.findMinSum(grid));
		System.out.println(obj.findMinSumDP(grid));
	}
}
