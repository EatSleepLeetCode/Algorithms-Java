import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintAllPathsFromSrcToTgtDirectedOrUnDirected 
{
	/**********************************************************
	 * 
	 *	Below code works for both directed or undirected graphs
	 *	The implementation below is for directed though, the
	 *	only thing to change would be to use undirected graph
	 *	class instead of directed graph class below.
	 * 
	 **********************************************************/
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        Graph g = new Graph();
        int n = graph.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < graph[i].length; j++)
            {
                g.addEdge(i, graph[i][j]);
            }
        }

        List<Integer> curr = new ArrayList<Integer>();
        
//        dfs1(g, result, 0, n - 1, curr);
        
        // OR
        
        curr.add(0);
        dfs2(g, result, 0, n - 1, curr);
        
        return result;
    }

    void dfs1(Graph g, List<List<Integer>> result, int src, int dest, List<Integer> curr)
    {   	
    	curr.add(src);
        if(src == dest)
        {
            result.add(new ArrayList<Integer>(curr));
        }
        else
        {
            Set<Integer> adjList = g.adj.get(src);            
            if(adjList != null)
            {
                for(int neighbor : adjList)
                {
                	//We don't need a dedicated visited array, instead use curr to check it.
                	//Note: The below check is only required when cycle can exist in the graph.
                	//So, for a directed acyclic graph this check is not required; 
                	//however, it's a good practice to always do this check. Another, benefit is 
                	//that with below condition, this solution will also work for undirected graph.
                	
                	if(curr.contains(neighbor))
                		continue;
                	
                    dfs1(g, result, neighbor, dest, curr);
                }
            }
        }
        curr.remove(curr.size() - 1);
    }
    
    void dfs2(Graph g, List<List<Integer>> result, int src, int dest, List<Integer> curr)
    {   	
        if(src == dest)
        {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        Set<Integer> adjList = g.adj.get(src);
        if(adjList != null)
        {
            for(int neighbor : adjList)
            {
            	//We don't need a dedicated visited array, instead use curr to check it.
            	//Note: The below check is only required when cycle can exist in the graph.
            	//So, for a directed acyclic graph this check is not required; 
            	//however, it's a good practice to always do this check. Another, benefit is 
            	//that with below condition, this solution will also work for undirected graph.
            	
            	if(curr.contains(neighbor))
            		continue;
            	
                curr.add(neighbor);
                dfs2(g, result, neighbor, dest, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
	public static void main(String[] args) 
	{
		PrintAllPathsFromSrcToTgtDirectedOrUnDirected obj = new PrintAllPathsFromSrcToTgtDirectedOrUnDirected();
		//Input when cycle doesn't exist
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2}, {3}, {3}, {}}));
		//Input when cycle exists
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2}, {2,3}, {0,3}, {}}));
		//Input when cycle exists
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2,3}, {3}, {0,1}, {}}));
	}
}

class Graph
{
    Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
    
    void addEdge(int u, int v)
    {
        adj.putIfAbsent(u, new HashSet<Integer>());
        adj.get(u).add(v);
        
        //Uncomment to make it work for undirected graphs
        /*
        adj.putIfAbsent(v, new HashSet<Integer>());
        adj.get(v).add(u);
        */
    }
}
