
/*
 * There are m eggs and n floors.
 * If we drop egg from kth floor then it either breaks or it doesn't break.
 * 		If it breaks then we have (m - 1) eggs and (k - 1) floors to work with.
 * 		If it doesn't break then we have (m) eggs and (floors - x) floors to work with.
 * 
 * While building the dp table we repeat the above process for each floor
 */

public class EggDroppingProblem 
{
	int minDropsRecursive(int eggs, int floors)
	{
		if(eggs == 1)
			return floors;
		
		if(floors == 0)
			return 0;
		
		int min = Integer.MAX_VALUE;
		int numAttempts = 0;
		for(int k = 1; k <= floors; k++)
		{
			numAttempts = 1 + Math.max(minDropsRecursive(eggs - 1, k - 1), minDropsRecursive(eggs, floors - k));
			min = Math.min(min, numAttempts);
		}
		return min;
	}
	
	int minDrops(int eggs, int floors)
	{
		int[][] dp = new int[eggs + 1][floors + 1];
		
		//If there is 1 egg then we have to try for each floor so answer is num of floors
		for(int j = 0; j <= floors; j++)
		{
			dp[1][j] = j;
		}
		
		for(int i = 2; i <= eggs; i++)				//Loop 1
		{
			for(int j = 1; j <= floors; j++)		//Loop 2
			{
				int min = Integer.MAX_VALUE;
				int numAttempts = 0;
				
				for(int k = 1; k <= j; k++)			//Loop 3
				{
					numAttempts = 1  + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
					min = Math.min(min, numAttempts);
				}
				dp[i][j] = min;
			}
		}
		return dp[eggs][floors];
	}
	
	public static void main(String[] args) 
	{
		EggDroppingProblem obj = new EggDroppingProblem();
		int eggs = 2;
		int floors = 6;
		System.out.println(obj.minDrops(eggs, floors));
		System.out.println(obj.minDropsRecursive(eggs, floors));
		
		eggs = 2;
		floors = 100;
		System.out.println(obj.minDrops(eggs, floors));
		//System.out.println(obj.minDropsRecursive(eggs, floors));	//It will take forever to run
		
		eggs = 10;
		floors = 100;
		System.out.println(obj.minDrops(eggs, floors));
		//System.out.println(obj.minDropsRecursive(eggs, floors));	//It will take forever to run
	}
}