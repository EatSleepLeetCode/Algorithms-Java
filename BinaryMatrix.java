import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryMatrix 
{
    public int[][] updateMatrix(int[][] matrix) 
    {        
        int rows = matrix.length;
        if (rows == 0) return new int[0][0];
        int cols = matrix[0].length;
        if (cols == 0) return new int[0][0];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    queue.offer(new int[]{i, j});
                }
                else
                {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        updateDistance(matrix, queue);
        return matrix;
    }
    
    void updateDistance(int[][] matrix, Queue<int[]> queue)
    {        
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = matrix.length;
        int cols = matrix[0].length;    

        while (!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            
            for (int[] dir : dirs)
            {
                int neiRow = row + dir[0];
                int neiCol = col + dir[1];
                
                if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols || 
                    matrix[neiRow][neiCol] <= matrix[row][col] + 1)
                    continue;
                
                matrix[neiRow][neiCol] = matrix[row][col] + 1;
                queue.offer(new int[]{neiRow, neiCol});
            }
        }
    }
    
	public static void main(String[] args) 
	{
		BinaryMatrix obj = new BinaryMatrix();
		obj.updateMatrix(new int[][] {{0,0,0},{0,1,0},{0,0,0}});
	}

}
