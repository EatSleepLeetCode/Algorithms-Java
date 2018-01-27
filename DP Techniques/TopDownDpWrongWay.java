import java.util.Arrays;

public class TopDownDPWrongWay 
{
	int findMinSumTopDownDP(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] cache = new int[rows][cols];
		
		for(int i = 0; i < rows; i++)
			Arrays.fill(cache[i], -1);
		
		return helperDP(grid, cache, 0, 0, rows, cols);
	}
	
	int helperDP(int[][] matrix, int[][] cache, int row, int col, int rows, int cols)
	{
		if(cache[row][col] != -1)
		{
			return cache[row][col];			
		}
	
		if(row == rows - 1 && col == cols - 1)			
		{
			return matrix[row][col];
		}

		int cmin = Integer.MAX_VALUE;
		
		for(int[] dir : new int[][] {{0, 1}, {1, 0}})
		{
			int incRow = dir[0];
			int incCol = dir[1];
			
			int updRow = row + incRow;
			int updCol = col + incCol;
			
			if(updRow < 0 || updRow >= rows || updCol < 0 || updCol >= cols)
			{
				continue;
			}
			int sum = matrix[row][col] + helperDP(matrix, cache, updRow, updCol, rows, cols);
			cmin =  Math.min(cmin, sum);
		}
		
		cache[row][col] = cmin;
		return cmin;
	}

	
	public static void main(String[] args) 
	{
		TopDownDPWrongWay obj = new TopDownDPWrongWay();
		
		int[][] grid = new int[][]{
									{31, 100, 65, 12, 18},
									{10, 13, 47, 157, 6},
									{100, 113, 174, 11, 33},
									{88, 124, 41, 20, 140},
									{99, 32, 111, 41, 20}};

		System.out.println(obj.findMinSumTopDownDP(grid));
	}

}
