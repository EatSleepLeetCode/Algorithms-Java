
public class LongestMountain 
{
    public int longestMountain1(int[] A) 
    {
        int n = A.length;
        int[] up = new int[n];
        int[] down = new int[n];
        int max = Integer.MIN_VALUE;
        
        for (int i = n - 2; i >= 0; i--)    //n - 2 to 0
        {
            if (A[i] > A[i + 1])
                down[i] = down[i + 1] + 1;
        }
        
        for (int i = 1; i < n; i++)         //1 to n - 1
        {
            if (A[i] > A[i - 1])
                up[i] = up[i - 1] + 1;
        }
        
        for (int i = 0; i < n; i++)         //0 to n -1
        {
            if (up[i] > 0 && down[i] > 0)
                max = Math.max(max, up[i] + down[i] + 1);
        }

        return max >= 3 ? max : 0;
    }
    
    public int longestMountain(int[] A) 
    {
        int n = A.length;
        int up = 0;
        int down = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < n; i++)
        {
            if ((down > 0 && A[i - 1] < A[i]) || A[i - 1] == A[i])
            {
                up = 0;
                down = 0;
            }
            
            if (A[i - 1] < A[i])
                up++;
            
            if (A[i - 1] > A[i])
                down++;
            
            if (up > 0 && down > 0)
                max = Math.max(max, up + down + 1);
        }
        return max >= 3 ? max : 0;
    }

    public static void main(String[] args) 
    {
    	LongestMountain obj = new LongestMountain();
    	System.out.println(obj.longestMountain1(new int[] {0,1,0,2,2}));
    	System.out.println(obj.longestMountain1(new int[] {2,1,4,7,3,2,5}));
    	System.out.println(obj.longestMountain1(new int[] {0,1,2,3,4,5,4,3,2,1,0}));
    	System.out.println(obj.longestMountain1(new int[] {875,884,239,731,723,685}));
    	System.out.println(obj.longestMountain1(new int[] {0,0,1,0,0,1,1,1,1,1}));
    	
    	System.out.println(obj.longestMountain(new int[] {0,1,0,2,2}));
    	System.out.println(obj.longestMountain(new int[] {2,1,4,7,3,2,5}));
    	System.out.println(obj.longestMountain(new int[] {0,1,2,3,4,5,4,3,2,1,0}));
    	System.out.println(obj.longestMountain(new int[] {875,884,239,731,723,685}));
    	System.out.println(obj.longestMountain(new int[] {0,0,1,0,0,1,1,1,1,1}));    	

	}
}
