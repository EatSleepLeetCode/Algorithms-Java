import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycleDirectedGraph 
{
	boolean detectCycle(GraphDirected graph, Map<Integer, Integer> visited)
	{
		for(int vertex : graph.vertices)
		{
			visited.put(vertex, 0);
		}
		
		for(int vertex : graph.vertices)
		{
			if(visited.get(vertex) == 0)
			{
				if(detectCycleUtil(graph, visited, vertex))
					return true;
			}
		}
		return false;
	}
	
	boolean detectCycleUtil(GraphDirected graph, Map<Integer, Integer> visited, int src)
	{
		visited.put(src, 1);
		
		Set<Integer> neighbors = graph.adj.get(src); 
		
		if(neighbors != null)
		{
			for(int neighbor : neighbors)
			{
				if(visited.get(neighbor) == 2)
					continue;
				
				if(visited.get(neighbor) == 1)
					return true;
				
				if(detectCycleUtil(graph, visited, neighbor))	//only check if visited state is 0 i.e. in white set
				{
					return true;
				}
			}			
		}

		visited.put(src, 2);
		return false;
	}
	
	public static void main(String[] args) 
	{

//		Graph graph = new Graph();
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 1);
		

		GraphDirected graph = new GraphDirected();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 4);
		
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		
		DetectCycleDirectedGraph obj = new DetectCycleDirectedGraph();
		System.out.println(obj.detectCycle(graph, visited));
	}
}