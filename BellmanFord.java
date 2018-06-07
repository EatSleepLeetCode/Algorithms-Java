import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BellmanFord 
{
	//Time Complexity: O(V * E) - in the worst case scenario E = V^2
	//Space Complexity: O(V)
	boolean bellmanFord(int[][]graph, int src)
	{
		Map<Integer, List<int[]>> edgeMap = new HashMap<Integer, List<int[]>>();
		Map<Integer, Integer> distMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
		
		for (int[] edge : graph)
		{
			edgeMap.putIfAbsent(edge[0], new ArrayList<int[]>());
			edgeMap.get(edge[0]).add(new int[] {edge[1], edge[2]});
			distMap.put(edge[0], Integer.MAX_VALUE);
			parentMap.put(edge[0], null);
		}
		
		distMap.put(src, 0);								//Set distance for src vertex to 0

		for (int i = 0; i < edgeMap.size() - 1; i++)		//Iterate v - 1 times
			relaxEdge(edgeMap, distMap, parentMap);
		
		if (relaxEdge(edgeMap, distMap, parentMap))			//Check for negative weight cycle
			return true;
		
		//Print shortest path
		StringBuilder sb = new StringBuilder();
		Set<Integer> visited = new HashSet<Integer>();
		for (int vertex : edgeMap.keySet())
		{
			if (!visited.contains(vertex))			
				dfs(vertex, visited, parentMap, sb);
		}
		System.out.println(sb.toString());
		
		return false;
	}
		
	boolean relaxEdge(Map<Integer, List<int[]>> edgeMap, Map<Integer, Integer> distMap, Map<Integer, Integer> parentMap)
	{
		boolean foundShorter = false;
		
		for (int u : edgeMap.keySet())
		{
			for (int[] edge : edgeMap.get(u))
			{
				int v = edge[0];
				int wt = edge[1];
				
				if (distMap.get(v) > distMap.get(u) + wt)
				{
					distMap.put(v, distMap.get(u) + wt);
					parentMap.put(v, u);
					foundShorter = true;
				}
			}
		}
		return foundShorter;
	}
	
	void dfs(int src, Set<Integer> visited, Map<Integer, Integer> parentMap, StringBuilder sb)
	{
		visited.add(src);
		
		if (parentMap.get(src) != null && !visited.contains(parentMap.get(src)))
			dfs(parentMap.get(src), visited, parentMap, sb);
		
		sb.append(src).append(" ");
	}
	
	public static void main(String[] args) 
	{
		BellmanFord obj = new BellmanFord();
		obj.bellmanFord(new int[][] {{3, 4, 2}, {4, 3, 1}, {2, 4, 4}, {0, 2, 5}, {1, 2, -3}, {0, 3, 8}, {0, 1, 4}}, 0);
		
		obj.bellmanFord(new int[][] {{0, 1, 1}, {1, 2, 3}, {2, 3, 2}, {3, 1, -6}}, 0);
	}
}
