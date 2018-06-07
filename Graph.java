import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Graph
{
	Set<Integer> vertices;
	Map<Integer, Set<Integer>> adjList;
	
	public Graph()
	{
		vertices = new HashSet<Integer>();
		adjList = new HashMap<Integer, Set<Integer>>();
	}
	
	void addEdge(int src, int dest)
	{
		vertices.add(src);
		vertices.add(dest);
		
		if(!adjList.containsKey(src))
		{
			adjList.put(src, new HashSet<Integer>());
		}
		
		adjList.get(src).add(dest);		
	}
}