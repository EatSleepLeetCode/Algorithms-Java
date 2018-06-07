import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SumOfDistancesInTree 
{
    int n;
    public int[] sumOfDistancesInTree(int N, int[][] edges) 
    {
        n = N;
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        int[] result = new int[N];
        int[] count = new int[N];
        
        //Build graph
        for(int i = 0; i < edges.length; i++)
        {
            adj.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.putIfAbsent(edges[i][1], new ArrayList<Integer>());
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        dfs1(adj, visited, result, count, 0);
        
        visited = new HashSet<Integer>();
        dfs2(adj, visited, result, count, 0);
        
        return result;
    }
    
    void dfs1(Map<Integer, List<Integer>> adj, Set<Integer> visited, int[] result, int[] count, int src)
    {
        visited.add(src);
        if(adj.get(src) != null)
        {
        	for(int nei : adj.get(src))
        	{
        		if(visited.contains(nei))
        			continue;
        		
        		dfs1(adj, visited, result, count, nei);                     //Post order
        		count[src] += count[nei];
        		result[src] += result[nei] + count[nei];
        	}
        	count[src]++;
        }
    }
    
    void dfs2(Map<Integer, List<Integer>> adj, Set<Integer> visited, int[] result, int[] count, int src)
    {
        visited.add(src);
        if(adj.get(src) != null)
        {
	        for(int nei : adj.get(src))
	        {
	            if(visited.contains(nei))
	            	continue;
	            
	        	result[nei] = result[src] - count[nei] + n - count[nei];
	        	dfs2(adj, visited, result, count, nei);                     //Pre order
	        }
        }
    }
    
	public static void main(String[] args) 
	{
		SumOfDistancesInTree obj = new SumOfDistancesInTree();
		obj.sumOfDistancesInTree(6, new int[][] {{0,1},{0,2},{2,3},{2,4},{2,5}});
	}
}