import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GraphDirected
{
	Set<Integer> vertices;
	Map<Integer, Set<Integer>> adj;
	
	public GraphDirected()
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
	}
}