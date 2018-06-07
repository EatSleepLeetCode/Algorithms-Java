import java.util.Arrays;

public class LargestPlusSign 
{
    public int orderOfLargestPlusSign(int N, int[][] mines) 
    {
        int[][] matrix = new int[N][N];
        
        for(int[] subMatrix : matrix)
        {
            Arrays.fill(subMatrix, 1);
        }
        
        for(int[] mine : mines)
        {
            matrix[mine[0]][mine[1]] = 0;
        }
        
        int count = 0;
        
        if(mines.length < N*N)
            count = 1;
        
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] top = new int[N][N];
        int[][] bottom = new int[N][N];
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(matrix[i][j] == 1)
                {
                    top[i][j] = i - 1 >= 0 ? top[i - 1][j] + 1: 1;
                    left[i][j] = j - 1 >= 0 ? left[i][j - 1] + 1: 1;
                }
            }
        }
        
        for(int i = N - 1; i >= 0; i--)
        {
            for(int j = N - 1; j >= 0; j--)
            {
                if(matrix[i][j] == 1)
                {
                    bottom[i][j] = i + 1 < N ? bottom[i + 1][j] + 1: 1;
                    right[i][j] = j + 1 < N ? right[i][j + 1] + 1: 1;
                }

                count = Math.max(count, Math.min(
                                 Math.min(top[i][j], bottom[i][j]), 
                                 Math.min(left[i][j], right[i][j])));
            }
        }
        return count;
    }
	
    public static void main(String[] args) 
	{
    	LargestPlusSign obj = new LargestPlusSign();
    	System.out.println(obj.orderOfLargestPlusSign(3, new int[][] {{0, 0}}));
	}
}
