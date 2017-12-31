
public class PourWater 
{
    //We wanted to avoid writing very similar functions for
    //findLeft and findRight. Now we use loopDir to drive
    //the loops. The only extra thing we are doing is terminal
    //condition includes checking both i >= 0 && i < n.
	int findIndex(int[] heights, int index, int loopDir)
	{
        int n = heights.length;
		int minIndex = -1;
		int minHeight = heights[index];
		
		for(int i = index + loopDir; i >= 0 && i < n; i = i + loopDir)
		{
			int currHeight = heights[i];
			if(currHeight > minHeight)
			{
				break;
			}
			else if(currHeight < minHeight)
			{
				minHeight = currHeight;
				minIndex = i;
			}
		}
		return minIndex;
	}
		
	public int[] pourWater(int[] heights, int volume, int index) 
    {
		for(int i = 0; i < volume; i++)
		{
			int left = findIndex(heights, index, -1);
			int right = findIndex(heights, index, 1);
			
			if(left != -1)
			{
				heights[left]++;
			}
			else if(right != -1)
			{
				heights[right]++;
			}
			else
			{
				heights[index]++;
			}
		}
		return heights;
    }
	
	public static void main(String[] args) 
	{
		PourWater obj = new PourWater();
		int[] heights = new int[] {2,1,1,2,1,2,2};
		obj.pourWater(heights, 4, 3);
	}
}
