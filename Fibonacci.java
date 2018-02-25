
public class Fibonacci 
{
	int fibRecursion(int n)
	{
		if(n <= 1)
			return n;
		
		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}
	
	int fibIterative(int n)
	{
		if(n <= 1)
			return n;
		
		int first = 0;
		int second = 1;
		int third = 0;
		
		for(int i = 2; i <= n; i++)
		{
			third = second + first;
			first = second;
			second = third;
		}
		return third;
	}

	int fibDP(int n)
	{
		if(n <= 1)
			return n;
		
		int[] dp = new int[n + 1]; 
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp [i - 2];
		}
		return dp[n];
	}
	
	
	public static void main(String[] args) 
	{
		Fibonacci obj = new Fibonacci();
		for(int i = 0; i < 9; i++)
		{
			System.out.print(obj.fibRecursion(i));
			System.out.print(obj.fibIterative(i));
			System.out.print(obj.fibDP(i));
			System.out.println();
		}
	}
}
