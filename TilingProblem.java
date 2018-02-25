
public class TilingProblem 
{
	//Given 2 X n board and 2 X 1 tiles that can be rotated
	int problem1DP(int n)
	{
		if(n <= 1)
			return n;
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
		
	}
	
	int problem1Fibo(int n)
	{
		if(n <= 1)
			return n;
		
		int one = 1;
		int two = 1;
		int three = 0;
		
		for(int i = 2; i <= n; i++)
		{
			three = two + one;
			one = two;
			two = three;
		}
		return three;
		
	}

	//Given 2 X m board and 1 X m tiles that can be rotated
	int problem2(int n, int m)
	{
		int[] dp = new int[n + 1];
		
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++)
		{
			if(i == m)
				dp[i] = 2;
			else if(i < m)
				dp[i] = 1;
			else
				dp[i] = dp[i - 1] + dp[i - m];
		}
		return dp[n];		
	}
		
    public int dominoTromino(int N) 
    {
        if(N <= 2)
            return N;
        
        int[] dp = new int[N + 1];
                
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        for(int i = 4; i <= N; i++)
        {
            dp[i] = (dp[i - 1] * 2)  % (1000000000 + 7) + dp[i - 3] % (1000000000 + 7);
            dp[i] %= (1000000000 + 7);
        }
        return dp[N];
    }

	public static void main(String[] args) 
	{
		TilingProblem obj = new TilingProblem();
		int n = 7;
		System.out.println(obj.problem1DP(n));
		System.out.println(obj.problem1Fibo(n));
		
		System.out.println(obj.problem2(n,4));
		
		System.out.println(obj.dominoTromino(4));		
	}

}
