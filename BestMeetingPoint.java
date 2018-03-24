import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint 
{
	int minTotalDistance(int[][] grid)
	{
		int result = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		List<Integer>rowVals = new ArrayList<Integer>();
		List<Integer>colVals = new ArrayList<Integer>();
		
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(grid[i][j] == 1)
				{
					rowVals.add(i);
					colVals.add(j);
				}
			}
		}
		//Rows were already added in sorted order i.e. i = 0 to rows - 1
		//However, Cols were added in non-sorted order i.e. j = 0 to cols - 1 for each row
		//So sort colVals to get the correct median
		Collections.sort(colVals);
		
		int medianRow = rowVals.get(rowVals.size() / 2);
		int medianCol = colVals.get(colVals.size() / 2);
		
		for(int i = 0; i < rowVals.size(); i++)
			result += Math.abs(medianRow - rowVals.get(i));
		
		for(int i = 0; i < colVals.size(); i++)
			result += Math.abs(medianCol - colVals.get(i));
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		BestMeetingPoint obj = new BestMeetingPoint();
		int[][] grid = new int[][] {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(obj.minTotalDistance(grid));
	}
}
