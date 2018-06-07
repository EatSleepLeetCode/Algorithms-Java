import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS 
{
    public boolean validTree(int n, int[][] edges) 
    {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
    
        for (int i=0; i<n; ++i) 
        { 
        	adjList.add(new ArrayList<Integer>()); 
    	}
        
        for (int[] edge: edges) 
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0); 
        visited[0] = true;  										// vertex 0 is in the queue, being visited
        
        while (!q.isEmpty()) 
        {
            Integer cur = q.poll();
            
            for (Integer succ: adjList.get(cur)) 
            {
                if (visited[succ]) 
                { 
                	return false; 									// loop detected
            	}  
                
                if (!visited[succ]) 
                { 
                	q.offer(succ); 
                	visited[succ] = true; 
            	}
            }
        }

        for (boolean v: visited) 
        { 
        	if (!v) 											//not 1 single connected component
        	{ 
        		return false; 
    		} 
    	}  
        return true;
    }
}
