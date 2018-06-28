public class KnightProbability
{
    public double knightProbability(int N, int K, int startRow, int startCol) 
    {
        double[][] dp = new double[N][N];        
        int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        
        dp[startRow][startCol] = 1;
        
        while (K > 0)
        {
            K--;
            double[][] curr = new double[N][N];
            
            for (int row = 0; row < N; row++)
            {
                for (int col = 0; col < N; col++)
                {
                    for (int[] dir : dirs)
                    {
                        int neiRow = row + dir[0];
                        int neiCol = col + dir[1];
                        
                        if (neiRow < 0 || neiRow >= N || neiCol < 0 || neiCol >= N)
                            continue;
                        
                        curr[neiRow][neiCol] += dp[row][col] / 8;
                    }
                }
            }
            dp = curr;
        }
        
        double ans = 0.0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ans += dp[i][j];

        return ans;
    }
    
    public static void main(String[] args)
    {
        KnightProbability obj = new KnightProbability();
        System.out.println(obj.knightProbability(3, 2, 0, 0));
        System.out.println(obj.knightProbability(4, 4, 1, 1));
    }
}
