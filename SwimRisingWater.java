import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimRisingWater 
{
	  public int swimInWater(int[][] grid) 
	  {
	        int N = grid.length;
	        boolean[][] visited = new boolean[N][N];
	        
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((k1, k2) ->
	                grid[k1[0]][k1[1]] - grid[k2[0]][k2[1]]);
	        
	        pq.offer(new int[] {0, 0});
	        visited[0][0] = true;
	        int ans = 0;


	        while (!pq.isEmpty()) 
	        {
	            int[] k = pq.poll();
	            int row = k[0];
	            int col = k[1];
	            
	            ans = Math.max(ans, grid[row][col]);
	        
	            if (row == N-1 && col == N-1) 
	            	return ans;

	            for (int[] dir : new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) 
	            {
	                int updRow = row + dir[0];
	                int updCol = col + dir[1];
	                
	                if (updRow < 0 || updRow >= N || updCol < 0 || updCol >= N || visited[updRow][updCol])
	                	continue;
	                
	                pq.offer(new int[] {updRow, updCol});
                    visited[updRow][updCol] = true;
	            }
	        }
	        throw null;
	    }
	public static void main(String[] args) 
	{
		SwimRisingWater obj = new SwimRisingWater();
		int[][] grid = new int[][] {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		System.out.println(obj.swimInWater(grid));
	}

}
