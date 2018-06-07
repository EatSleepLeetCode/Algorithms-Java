import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class EscapeGhosts 
{
    //Solution 1
    public boolean escapeGhosts(int[][] ghosts, int[] target) 
    {
        int time = Math.abs(target[0]) + Math.abs(target[1]);
        
        for(int[] ghost : ghosts)
        {
            if(Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= time)
                return false;
        }
        return true;
    }
	
	//Solution 2 - DFS based modified question
    //Let's say we are given bounds for the grid, we assume them to be 20
	
	  int min = Integer.MAX_VALUE;
	    
	    public boolean escapeGhostsModified(int[][] ghosts, int[] target) 
	    {
	        int rows = 20;
	        int cols = 20;
	        BitSet [] visited = new BitSet[20];
	        for(int i = 0; i < 20; i++)
	        	visited[i]= new BitSet();
	        
	        dfs(rows, cols, 0, 0, target[0], target[1], 0, false, visited);
	        
	        for(int[] ghost : ghosts)
	        {
	            for(int i = 0; i < 20; i++)
	            	visited[i]= new BitSet();

	            if(!dfs(rows, cols, ghost[0], ghost[1], target[0], target[1], 0, true, visited ))
	            {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    boolean dfs(int rows, int cols, int row, int col, int targetRow, int targetCol, int time, boolean isGhost, BitSet[] visited)
	    {
	        if(row == targetRow && col == targetCol)
	        {
	            if(time <= min)
	            {
	                min = time;
	                
	                if(isGhost)
	                {
	                    return false;
	                }
	            }
	        }
	        
	        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row].get(col))
	            return true;
	        
	    	visited[row].set(col);
	        
	        if (!dfs(rows, cols, row + 1, col, targetRow, targetCol, time + 1, isGhost, visited) ||
	            !dfs(rows, cols, row - 1, col, targetRow, targetCol, time + 1, isGhost, visited) ||
	            !dfs(rows, cols, row, col - 1, targetRow, targetCol, time + 1, isGhost, visited) ||
	            !dfs(rows, cols, row, col + 1, targetRow, targetCol, time + 1, isGhost, visited))
	            return false;
	        
	        return true;
	    }
        
	public static void main(String[] args) 
	{
		EscapeGhosts obj = new EscapeGhosts();
		
		int[][] ghosts = new int[][] {{1, 0}, {0, 3}};
		int[] target = new int[] {0, 1};
		
//		int[][] ghosts = new int[][] {{1, 0}};
//		int[] target = new int[] {2, 0};
		
//		int[][] ghosts = new int[][] {{2, 0}};
//		int[] target = new int[] {1, 0};
		
		System.out.println(obj.escapeGhosts(ghosts, target));
		System.out.println(obj.escapeGhostsModified(ghosts, target));
	}
}
