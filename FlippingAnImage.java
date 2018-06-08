
public class FlippingAnImage 
{
    public int[][] flipAndInvertImage(int[][] A) 
    {
        int n = A.length;
        
        for (int row = 0; row < n; row++)
        {
            //we use (n + 1) / 2 because we want to update
            //middle element for both even and odd length cases.
            
            for (int col = 0; col < (n + 1) / 2; col++)
            {
                int backUp = A[row][col] ^ 1;
                A[row][col] = A[row][n - 1 - col] ^ 1;
                A[row][n - 1 - col] = backUp;
            }
        }
        return A;
    }
}
