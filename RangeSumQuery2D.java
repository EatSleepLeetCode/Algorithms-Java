
public class RangeSumQuery2D 
{
    int[][] cache;
    
    public RangeSumQuery2D(int[][] matrix) 
    {
        int rows = matrix.length;
        if (rows == 0)
            return ;
        int cols = matrix[0].length;
        if (cols == 0)
            return;
        
        cache = new int[rows + 1][cols + 1];        //rows + 1 and cols + 1
        
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                cache[row + 1][col + 1] = matrix[row][col] + cache[row + 1][col] + cache[row][col + 1] - cache[row][col];
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
        return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1] + cache[row1][col1];
    }
}