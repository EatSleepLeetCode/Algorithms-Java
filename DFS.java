import java.util.ArrayList;
import java.util.List;

public class DFS 
{
	public boolean validTree(int n, int[][] edges) 
	{
	    boolean[] visited = new boolean[n];
	    List<List<Integer>> adjList = new ArrayList<>();

	    for (int i = 0; i < n; i++) 
	    { 
	        adjList.add(new ArrayList<Integer>()); 
	    }
	    
	    for(int[] edge : edges) 
	    {
	        adjList.get(edge[0]).add(edge[1]);
	        adjList.get(edge[1]).add(edge[0]);
	    }
	    
	    if(hasCycle(-1, 0, visited, adjList)) 
	    { 
	        return false; 
	    }  
	    
	    for(boolean v : visited) 
	    { 
	        if (!v) 
	        { 
	            return false;                                   // not 1 single connected component
	        } 
	    }
	    
	    return true;
	}
	    
	private boolean hasCycle(int pred, int vertex, boolean[] visited, List<List<Integer>> adjList) 
	{
	    visited[vertex] = true;                                 // current vertex is being visited
	    
	    for (Integer succ : adjList.get(vertex))                // successors of current vertex
	    {  
	        if (succ != pred) 									// exclude current vertex's predecessor
	        {  													// because it's undirected graph
	            if (visited[succ])                              
	            {
	                return true;                                // back edge/loop detected!
	            }  
	            else if (!visited[succ]) 
	            {
	                if (hasCycle(vertex, succ, visited, adjList)) 
	                { 
	                    return true; 
	                }
	            }
	        }
	    }
	    return false;
	}
}
