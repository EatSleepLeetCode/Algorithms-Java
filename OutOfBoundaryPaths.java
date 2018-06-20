
public class OutOfBoundaryPaths 
{
    public int findPaths(int m, int n, int N, int i, int j) 
    {
        if (n <= 0) return 0;
        
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        
        for (int step = 0; step < N; step++)
        {
            int[][] temp = new int[m][n];
            for (int row = 0; row < m; row++)
            {
                for (int col = 0; col < n; col++)
                {
                    for (int[] dir : dirs)
                    {
                        int neiRow = row + dir[0];
                        int neiCol = col + dir[1];
                        
                        if (neiRow < 0 || neiRow >= m || neiCol < 0 || neiCol >= n)
                            result = (result + count[row][col]) % mod;
                        else
                            temp[neiRow][neiCol] = (temp[neiRow][neiCol] + count[row][col]) % mod;
                    }
                }
            }
            count = temp;
        }
        return result;
    }
}
