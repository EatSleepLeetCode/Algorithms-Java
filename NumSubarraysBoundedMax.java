
public class NumSubarraysBoundedMax 
{
    public int numSubarrayBoundedMax(int[] A, int L, int R) 
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
    
	public static void main(String[] args) 
	{
		NumSubarraysBoundedMax obj = new NumSubarraysBoundedMax();
		System.out.println(obj.numSubarrayBoundedMax(new int[] {2,1,4,3}, 2, 3));
	}
}
