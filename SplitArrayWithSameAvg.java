import java.util.Arrays;

public class SplitArrayWithSameAvg 
{
    public boolean splitArraySameAverage(int[] A) 
    {
        int n = A.length;
        
        if (n == 1) 
            return false;
        
        int sumA = 0;
        for (int i = 0; i < n; i++) 
            sumA += A[i];
        
        Arrays.sort(A);
        
        for (int lenOfB = 1; lenOfB <= A.length / 2; lenOfB++) 
        {
            if ((sumA * lenOfB) % A.length == 0) 
            {
                if (check(A, (sumA * lenOfB) / A.length, lenOfB, 0)) 
                    return true;
            }
        }
        return false;
    }
    
   public boolean check(int[] A, int leftSum, int leftNum, int startIndex) 
   {       
        if (leftNum == 0) 
            return leftSum == 0;
       
        if ((A[startIndex]) > leftSum / leftNum) 
            return false;
       
        for (int i = startIndex; i < A.length - leftNum + 1; i ++) 
        {
            if (check(A, leftSum - A[i], leftNum - 1, i + 1)) 
                return true;
        }
        return false;       
    }

	public static void main(String[] args) 
	{
		
	}
}
