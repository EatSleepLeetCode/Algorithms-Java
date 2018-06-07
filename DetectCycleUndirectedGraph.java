import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycleUndirectedGraph 
{	
	//Solution 1 - Using Disjoint Set using union by rank and path compression 
	boolean detectCycleUSingDisjointSet(int[][] edges)
	{
		DisjointSet ds = new DisjointSet();
		for(int[] edge : edges)
		{
			int vertex1 =  edge[0];
			int vertex2 =  edge[1];
			
			ds.makseSet(vertex1);
			ds.makseSet(vertex2);
			
			if(ds.findSet(vertex1) == ds.findSet(vertex2))
				return true;
			else
				ds.union(vertex1, vertex2);
		}
		
		return false;
	}
	
	//Solution 2 - Using DFS
	boolean detectCycle(Graph graph)
	{
		Set<Integer> visited = new HashSet<Integer>();
		for(int vertex : graph.vertices)
		{
			if(!visited.contains(vertex))
			{
				if(detectCycleUtil(graph, visited, vertex, -1))
					return true;
			}
		}
		return false;
	}
	
	boolean detectCycleUtil(Graph graph, Set<Integer> visited, int src, int pred)
	{
		visited.add(src);
		
		Set<Integer> neighbors = graph.adj.get(src); 
		
		if(neighbors != null)
		{
			for(int succesor : neighbors)
			{
				if(succesor == pred)
					continue;
				
				if(visited.contains(succesor))
					return true;
				
				if(detectCycleUtil(graph, visited, succesor, src))
				{
					return true;
				}
			}			
		}

		return false;
	}
	
	public static void main(String[] args) 
	{
		DetectCycleUndirectedGraph obj = new DetectCycleUndirectedGraph();
		
		//Solution 1		
//		int[][] edges = new int[][] {{1,2},{2,3},{1,3}};
		
		int[][] edges = new int[][] {{1,2},{1,3},{2,3},{1,4},{4,5}};
		
		System.out.println(obj.detectCycleUSingDisjointSet(edges));		
				
		
		//Solution 2
/*
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		
		graph.addEdge(3, 1);
		graph.addEdge(1, 3);
*/
		Graph graph = new Graph();
		graph.addEdge(2, 1);
		graph.addEdge(1, 2);
		
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		
		graph.addEdge(4, 5);
		graph.addEdge(5, 4);
		
		System.out.println(obj.detectCycle(graph));
	}
}
class Graph
{
	Set<Integer> vertices;
	Map<Integer, Set<Integer>> adj;
	
	public Graph()
	{
		vertices = new HashSet<Integer>();
		adj = new HashMap<Integer, Set<Integer>>();		
	}
	
	void addEdge(int src, int dest)
	{
		vertices.add(src);
		vertices.add(dest);
		
		if(!adj.containsKey(src))
		{
			adj.put(src, new HashSet<Integer>());
		}
		adj.get(src).add(dest);
		
		if(!adj.containsKey(dest))
		{
			adj.put(dest, new HashSet<Integer>());
		}
		adj.get(dest).add(src);
	}
}