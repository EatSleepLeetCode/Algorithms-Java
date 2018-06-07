/*
 * The idea is similar to the problem Paint House I, for each house and each color, the minimum cost 
 * of painting the house with that color should be the minimum cost of painting previous houses, and 
 * make sure the previous house doesn't paint with the same color.
 * 
 * We can use min1 and min2 to track the indices of the 1st and 2nd smallest cost till previous house, if the 
 * current color's index is same as min1, then we have to go with min2, otherwise we can safely go with min1.
 */

public class PaintHouseII 
{
	int minCost(int[][] cost)
	{
		int n = cost.length;
		if(n == 0)
			return 0;
		
		int k = cost[0].length;
		
		// min1 is the index of the 1st-smallest cost till previous house
	    // min2 is the index of the 2nd-smallest cost till previous house
		int min1 = -1;
		int min2 = -1;
		
		int last1 = -1;
		int last2 = -1;
		
		for(int i = 0; i < n; i++)
		{
			last1 = min1;
			last2 = min2;
					
			min1 = -1;
			min2 = -1;
			
			for(int j = 0; j < k; j++)
			{
				if(j != last1)
				{
					// current color j is different to last min1
					cost[i][j] += last1 < 0 ? 0 : cost[i - 1][last1];
				}
				else
				{
					cost[i][j] += last2 < 0 ? 0 : cost[i - 1][last2];
				}
				
				 // find the indices of 1st and 2nd smallest cost of painting current house i
				if(min1 < 0 || cost[i][j] < cost[i][min1])
				{
					min2 = min1;
					min1 = j;
				}
				else if(min2 < 0 || cost[i][j] < cost[i][min2])
				{
					min2 = j;
				}
			}
		}
		return cost[n - 1][min1];
	}
	
	public static void main(String[] args)
	{
		int[][] cost = new int[][] {{14, 2, 11},{11, 14, 5},{14, 3, 10}};
		PaintHouseII obj = new PaintHouseII();
		System.out.println(obj.minCost(cost));
	}
}
