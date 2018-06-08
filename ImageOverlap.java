
public class ImageOverlap 
{
    public int largestOverlap(int[][] A, int[][] B) 
    {
        int n = A.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        int result = 0;
        
        for (int iA = 0; iA < n; iA++)
        {
            for (int jA = 0; jA < n; jA++)
            {
                if (A[iA][jA] != 1) continue;
                
                for (int iB = 0; iB < n; iB++)
                {
                    for (int jB = 0; jB < n; jB++)
                    {
                        if (B[iB][jB] != 1) continue;
                        
                        count[iA - iB + n][jA - jB + n]++;
                    }
                }
            }
        }
        
        for (int[] row : count)
            for (int val : row)
                result = Math.max(result, val);
    
        return result;
    }
}
