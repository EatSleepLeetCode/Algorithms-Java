import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTrees 
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
        
        if(n == 0)
            return result;
        if(n == 1)
        {
            result.add(0);
            return result;
        }
        
        generateAdjListMap(edges, adj);       
        
        Queue<Integer> leavesQueue = new LinkedList<Integer>();
        for(int key : adj.keySet())
        {
            if(adj.get(key).size() == 1)    //i.e. it's a leaf node pointing to its parent
            {
                leavesQueue.offer(key);
            }
        }
        
        int count = n;
        while(!leavesQueue.isEmpty() && count > 2)
        {            
            int size = leavesQueue.size();
            count -= size;
            
            for(int i = 0; i < size; i++)
            {
                int leaf = leavesQueue.poll();
                
                Set<Integer> adjList = adj.get(leaf);
                if(adjList != null)
                {
                    //Remove each leaf from their neigh's adj list
                    for(int neighbor : adjList)
                    {
                        Set<Integer> neighborAdjList = adj.get(neighbor);
                        neighborAdjList.remove(leaf);

                        if(neighborAdjList.size() == 1)
                            leavesQueue.offer(neighbor);

                        adj.put(neighbor, neighborAdjList);
                    }
                }            
            }
        }
        
        while(!leavesQueue.isEmpty())
            result.add(leavesQueue.poll());
        
        return result;
    }
    
    void generateAdjListMap(int[][] edges, Map<Integer, Set<Integer>>adj)
    {
        int edgeCount = edges.length;
        for(int i = 0; i < edgeCount; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.putIfAbsent(u, new HashSet<Integer>());
            adj.get(u).add(v);
            adj.putIfAbsent(v, new HashSet<Integer>());
            adj.get(v).add(u);
        }
    }
    
	public static void main(String[] args) 
	{
		MinimumHeightTrees obj = new MinimumHeightTrees();
		System.out.println(obj.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
	}
}
