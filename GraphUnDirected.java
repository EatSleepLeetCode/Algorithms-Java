import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphUnDirected 
{
	Set<String> vertices;
	Map<String, Set<String>> adj;
	
	public GraphUnDirected()
	{
		vertices = new HashSet<String>();
		adj = new HashMap<String, Set<String>>();		
	}
	
	void addEdge(String src, String dest)
	{
		vertices.add(src);
		vertices.add(dest);
		
		if(!adj.containsKey(src))
		{
			adj.put(src, new HashSet<String>());
		}
		adj.get(src).add(dest);
		
		if(!adj.containsKey(dest))
		{
			adj.put(dest, new HashSet<String>());
		}
		adj.get(dest).add(src);
	}
}
