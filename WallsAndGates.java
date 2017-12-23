import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates 
{
	//Solution 1
	public void wallsAndGates1(int[][] rooms) 
	{
	    for(int i = 0; i < rooms.length; i++) 
	    {
	    	for(int j = 0; j < rooms[0].length; j++) 
	    	{
	            if(rooms[i][j] == 0) dfs(rooms, i, j, 0);
	        }
	    }
	}

	public void dfs(int[][] rooms, int i, int j, int d) 
	{
	    if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) 
	    	return;
	    
	    rooms[i][j] = d;
	    
	    dfs(rooms, i - 1, j, d + 1);
	    dfs(rooms, i, j - 1, d + 1);
	    dfs(rooms, i + 1, j, d + 1);
	    dfs(rooms, i, j + 1, d + 1);
	}
	
	//Solution 2
	int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public void wallsAndGates2(int[][] rooms) 
	{
	    for(int i = 0; i < rooms.length; i++) 
	    {
	        for(int j = 0; j < rooms[0].length; j++) 
	        {
	            if(rooms[i][j] == 0) 
	            {
	                dfs(rooms, i, j);
	            }              
	        }
	    }
	}

	public void dfs(int[][] rooms, int i, int j) 
	{
	    for(int[] dir : dirs) 
	    {
	        int x = i + dir[0];
	        int y = j + dir[1];
	        
	        if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] <= rooms[i][j]) 
	        	continue;
	        
	        rooms[x][y] = rooms[i][j] + 1;
	        
	        dfs(rooms, x, y);
	    }
	}
	
	//Solution 3 
	
	 public void wallsAndGates3(int[][] rooms) 
	 {
        if (rooms.length == 0 || rooms[0].length == 0) 
        	return;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) 
        {
            for (int j = 0; j < rooms[0].length; j++) 
            {
                if (rooms[i][j] == 0)
                {
                   	queue.offer(new int[]{i, j});	                	
                }
            }
        }
        
        while (!queue.isEmpty()) 
        {
            int[] top = queue.poll();
            
            int row = top[0];
            int col = top[1];
            
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) 
            {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.offer(new int[]{row - 1, col});
            }
            
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) 
            {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) 
            {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) 
            {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
