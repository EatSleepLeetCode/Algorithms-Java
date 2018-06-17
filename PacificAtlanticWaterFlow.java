import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow 
{
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) 
    {
        List<int[]> result = new ArrayList<int[]>();
        
        int rows = matrix.length;
        if (rows == 0)  return result;        
        int cols = matrix[0].length;
        if (cols == 0)  return result;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int row = 0; row < rows; row++)
        {
            dfs(matrix, pacific, Integer.MIN_VALUE, row, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, row, cols - 1);
        }
        
        for (int col = 0; col < cols; col++)
        {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, col);
            dfs(matrix, atlantic, Integer.MIN_VALUE, rows - 1, col);
        }
        
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if (pacific[row][col] && atlantic[row][col])
                {
                    result.add(new int[]{row, col});
                }
            }
        }
        return result;
    }
    
    void dfs(int[][] matrix, boolean[][] visited, int height, int row, int col)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix[row][col] < height)
            return;
        
        visited[row][col] = true;
        
        for (int[] dir : dirs)
        {
            dfs(matrix, visited, matrix[row][col], row + dir[0], col + dir[1]);
        }
    }
}
