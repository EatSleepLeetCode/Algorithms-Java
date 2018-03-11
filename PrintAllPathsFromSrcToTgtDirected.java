import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintAllPathsFromSrcToTgtDirected 
{
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
        curr.add(0);
        dfs(g, result, 0, n - 1, curr);
        return result;
    }

    void dfs(Graph g, List<List<Integer>> result, int src, int dest, List<Integer> curr)
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
                curr.add(neighbor);
                dfs(g, result, neighbor, dest, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
	public static void main(String[] args) 
	{
		PrintAllPathsFromSrcToTgtDirected obj = new PrintAllPathsFromSrcToTgtDirected();
		System.out.println(obj.allPathsSourceTarget(new int[][] {{1,2}, {3}, {3}, {}}));
	}
}

class Graph
{
    Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
    
    void addEdge(int u, int v)
    {
        adj.putIfAbsent(u, new HashSet<Integer>());
        adj.get(u).add(v);
    }
}
