import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventualSafeStates 
{
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        Graph g = new Graph();
        int n = graph.length;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)            
        {
            for(int j = 0; j < graph[i].length; j++)
            {
                g.addEdge(i, graph[i][j]);
            }
        }
        
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        for(int j = 0; j < n; j++)  
            visited.put(j, 0);
        
        for(int i = 0 ; i < n; i++)
        {
            if(dfs(g, visited, i))
            {
                result.add(i);
            }
        }
        return result;
    }
    
    boolean dfs(Graph g, Map<Integer, Integer> visited, int src)
    {
        visited.put(src, 1);
        
        Set<Integer> adjList = g.adj.get(src);
        if(adjList != null)
        {
            for(int neighbor : adjList)
            {                
                if(visited.get(neighbor) == 2)
                    continue;
                
                if(visited.get(neighbor) == 1)
                	return false;
                
                if(!dfs(g, visited, neighbor))      //Imp to check and return false
                    return false;
            }
        }
        visited.put(src, 2);
        return true;
    }
	
	public static void main(String[] args) 
	{
		EventualSafeStates obj = new EventualSafeStates();
		System.out.println(obj.eventualSafeNodes(new int[][] {{1,2},{2,3},{5},{0},{5},{},{}}));
	}
}

class Graph
{
    Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
    
    void addEdge(int src, int dest)    
    {
        adj.putIfAbsent(src, new HashSet<Integer>());
        adj.get(src).add(dest);
    }
}