
public class ClimbingStairs 
{
    public int climbStairs(int n) 
    {
        int[] dp = new int[n + 1];
        
        if(n <= 2)
            return n;        
        
        dp[1] = 1;  //only 1 way to reach step
        dp[2] = 2;  //2 ways to reach step 2
        
        for(int i = 3; i <= n; i ++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public int climbStairs2(int n) 
    {
        if(n <= 2)
            return n;
        
        int first = 1;
        int second = 2;
        int third = 0;
        
        for(int i = 3; i <= n; i++)
        {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
    
    //Generic solution
    //n is the step you want to reach
    //m is the number of steps you can take - 1, 2, ..., m
    int climbStairsGeneric(int n, int m)
    {
    	if(n <= 2)
    		return n;
    	
        int dp[] = new int[n + 1];
         
        dp[0] = 1;	//Special case for Generic
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++)
        {
           dp[i] = 0;
           for (int j = 1; j <= m && j <= i; j++)
           {
        	   dp[i] += dp[i - j];
           }
        }
        return dp[n];
    }
    
	public static void main(String[] args) 
	{
		ClimbingStairs obj = new ClimbingStairs();
		System.out.println(obj.climbStairs(4));
		System.out.println(obj.climbStairs2(4));
		System.out.println(obj.climbStairsGeneric(6, 5));
	}
}
