
public class NumSubarraysBoundedMax 
{
	 //Solution 1 - O(n^2)
    public int numSubarrayBoundedMax1(int[] A, int L, int R) 
    {
        int n = A.length;        
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(A[i] > R)
                continue;
            
            int j = 0;            
            int max = Integer.MIN_VALUE;
            for(j = i; j < n; j++)
            {                              
                max = Math.max(max, A[j]);
                
                if(max > R)
                   break; 
                if(max >= L)
                    count++;
            }    
        }
        return count;
    }

    //Solution 2 - O(n)
    public int numSubarrayBoundedMax2(int[] A, int L, int R) 
    {
        int res = 0, heads = 0, tails = 0;
        for (int val : A) 
        {
            if (L <= val && val <= R) 
            {
                // val is a head. All tails promoted to heads
                heads+= tails + 1;
                tails = 0;
                res += heads;
            }
            else if (val < L) 
            {
                // val is a tail, can extend existing subarrays
                tails++;
                res += heads;
            }
            else 
            {
                // combo breaker
                heads = 0;
                tails = 0;
            }
        }
        return res;
    }
    
	public static void main(String[] args) 
	{
		NumSubarraysBoundedMax obj = new NumSubarraysBoundedMax();
		System.out.println(obj.numSubarrayBoundedMax1(new int[] {2,1,4,3}, 2, 3));
		System.out.println(obj.numSubarrayBoundedMax2(new int[] {2,1,4,3}, 2, 3));
	}
}
