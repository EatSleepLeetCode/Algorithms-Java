
public class DiagonalTraverse 
{
	public int[] findDiagonalOrder(int[][] matrix) 
    {
        int rows = matrix.length;
        if (rows == 0)
            return new int[0];
        
        int cols = matrix[0].length;
        if (cols == 0)
            return new int[0];
        
        int[] result = new int[rows * cols];
        int row = 0, col = 0, d = 1;        
        
        for (int i = 0; i < rows * cols ; i++)
        {
            result[i] = matrix[row][col];
            row -= d;
            col += d;
            
            // Note: The order of if conditions matter
            if (row >= rows)
            {
                row = rows - 1;
                col += 2;
                d = -d;
            }
            
            if (col >= cols)
            {
                col = cols - 1;
                row += 2;
                d = -d;
            }
            
            if (row < 0)
            {
                row = 0;
                d = -d;
            }
            
            if (col < 0)
            {
                col = 0;
                d = -d;
            }            
        }
        return result;
    }
}
