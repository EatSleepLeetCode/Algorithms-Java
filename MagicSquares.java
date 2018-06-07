import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MagicSquares 
{
    int count = 0;
    public int numMagicSquaresInside(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i <= rows - 3; i++)
            for (int j = 0; j <= cols - 3; j++)
                findSum (grid, i, j);

        return count;
    }
    
    void findSum(int[][] grid, int row, int col)
    {
        int[] diagSum = new int[2];
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        Set<Integer> unique = new HashSet<Integer>();
        
        for (int i = row; i < row + 3; i++)
        {
            for (int j = col; j < col + 3; j++)
            {
                if (!unique.add(grid[i][j])) return;
                
                if(grid[i][j] < 1 || grid[i][j] > 9) return;
                    
                rowSum[i - row] += grid[i][j];
                colSum[j - col] += grid[i][j];
                
                //Diagonal
                if(i + col == j + row)
                	diagSum[0] += grid[i][j];
                
                //Reverse Diagonal
                //Difference from N-Queens is that there col represents max. col
                //and here col represents col start offset. So we add 2 to make it
                //max col.
                if(i + j == row + col + 2)
                    diagSum[1] += grid[i][j];
            }
        }
        
        for (int i = 1; i < 3; i++)
        {
            if(rowSum[i] != rowSum[i - 1])
                return;
            if(colSum[i] != colSum[i - 1])
                return;            
        }

        if(diagSum[0] != diagSum[1]) return;
        if(rowSum[0] != colSum[0]) return;
        if(rowSum[0] != diagSum[0]) return;
        
        count++;
    }

	public static void main(String[] args) 
	{
		Solution obj = new Solution();	
		System.out.println(obj.numMagicSquaresInside(new int[][] {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}}));
		System.out.println();
	}	
}