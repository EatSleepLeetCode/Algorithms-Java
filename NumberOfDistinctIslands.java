import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands 
{
	int numOfDistinctIslands(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		Set<String> islandSet = new HashSet<String>();
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(matrix[i][j] == 1)
				{
					StringBuilder sb = new StringBuilder();
					helper(matrix, i, j, i, j, rows, cols, sb);
					islandSet.add(sb.toString());
				}
			}
		}

		return islandSet.size();
	}
	void helper(int[][] matrix, int row, int col, int startRow, int startCol, int rows, int cols, StringBuilder sb)
	{
		if(row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != 1)
			return;
		
		sb.append(startRow - row).append(startCol - col);
		matrix[row][col] = 0;
		
		helper(matrix, row - 1, col, startRow, startCol, rows, cols, sb);
		helper(matrix, row + 1, col, startRow, startCol, rows, cols, sb);
		helper(matrix, row, col - 1, startRow, startCol, rows, cols, sb);
		helper(matrix, row, col + 1, startRow, startCol, rows, cols, sb);
	}
	
	public static void main(String[] args) 
	{
		NumberOfDistinctIslands obj = new NumberOfDistinctIslands();
		int[][] matrix = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(obj.numOfDistinctIslands(matrix));
		
		matrix = new int[][] {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
		System.out.println(obj.numOfDistinctIslands(matrix));
	}
}
