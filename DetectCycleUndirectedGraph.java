import java.util.HashMap;
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
	boolean detectCycle(Graph graph, Map<Integer, Boolean> visited)
	{
		for(int vertex : graph.vertices)
		{
			visited.put(vertex, false);
		}
		
		for(int vertex : graph.vertices)
		{
			if(!visited.get(vertex))
			{
				if(detectCycleUtil(graph, visited, vertex, -1))
					return true;
			}
		}
		return false;
	}
	
	boolean detectCycleUtil(Graph graph, Map<Integer, Boolean> visited, int src, int pred)
	{
		visited.put(src, true);
		
		Set<Integer> neighbors = graph.adjList.get(src); 
		
		if(neighbors != null)
		{
			for(int succesor : neighbors)
			{
				if(succesor == pred)
					continue;
				
				if(visited.get(succesor))
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
		
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();		
		System.out.println(obj.detectCycle(graph, visited));
	}
}

