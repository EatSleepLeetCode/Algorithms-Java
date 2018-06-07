import java.util.Arrays;

public class Recursion 
{
	int min = Integer.MAX_VALUE;
	
	int findMinSum(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		recursion(grid, 0, 0, rows, cols, 0 ,visited);
		return min;
	}
	
	void recursion(int[][] grid, int row, int col, int rows, int cols, int currSum, boolean[][] visited)
	{
		if(row == rows - 1 && col == cols - 1)
		{
			min = Math.min(min, currSum + grid[row][col]);
			return;
		}

		if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
			return;
		
		visited[row][col] = true;
	
		recursion(grid, row + 1, col, rows, cols, currSum + grid[row][col], visited);
		recursion(grid, row, col + 1, rows, cols, currSum + grid[row][col], visited);
		
		visited[row][col] = false;
	}
	
	
	public static void main(String[] args) 
	{
		Recursion obj = new Recursion();
		
		int[][] grid = new int[][]{
									{31, 100, 65, 12, 18},
									{10, 13, 47, 157, 6},
									{100, 113, 174, 11, 33},
									{88, 124, 41, 20, 140},
									{99, 32, 111, 41, 20}};

		System.out.println(obj.findMinSum(grid));
	}

}
