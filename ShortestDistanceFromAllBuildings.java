import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings 
{
	int shortestDistance(int[][] grid)
	{
		int result = Integer.MAX_VALUE;
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] distance = new int[rows][cols];
		int[][] buildingReachCount = new int[rows][cols];
		int buildingCount = 0;
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(grid[i][j] == 1)
				{
					buildingCount++;
					boolean[][] visited = new boolean[rows][cols];
					bfs(grid, distance, buildingReachCount, visited, i, j);
				}
			}
		}
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(buildingReachCount[i][j] == buildingCount)
				{
					result = Math.min(result, distance[i][j]);
				}
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	void bfs(int[][] grid, int[][] distance, int[][] buildingReachCount, boolean[][] visited, int row, int col)
	{
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int distanceSofar = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!q.isEmpty())
		{
			distanceSofar++;				//Important
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				int[] curr = q.poll();
				int currRow = curr[0];
				int currCol = curr[1];
				
				for(int[] dir : dirs)
				{
					int neiRow = currRow + dir[0];
					int neiCol = currCol + dir[1];
					
					if(neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols || 
							visited[neiRow][neiCol] || grid[neiRow][neiCol] != 0)
						continue;
					
					q.offer(new int[] {neiRow, neiCol});
					visited[neiRow][neiCol] = true;
					distance[neiRow][neiCol] += distanceSofar;
					buildingReachCount[neiRow][neiCol]++;
				}
			}			
		}
	}
	
	public static void main(String[] args) 
	{
		ShortestDistanceFromAllBuildings obj = new ShortestDistanceFromAllBuildings();
		int[][] grid = new int[][] {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
		
		System.out.println(obj.shortestDistance(grid));
	}
}
