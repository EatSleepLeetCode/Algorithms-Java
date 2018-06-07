import java.util.Arrays;

public class ShortestPathVisitingAllNodes 
{
	/*
    1. A pure DFS will lead to TLE, using cache to avoid repeated computation.
	
    2. Since 1 <= graph.length <= 12 (as given in problem constraints), we can use a single 
	integer to represent the nodes we already visited.
    
	3. cache[i][j] here means the shortest path when we have 'i' visited nodes and start at j
    e.g. i = ...0111, which means we already visited nodes 0, 1, 2
	*/
	
	public int shortestPathLength(int[][] graph) 
    {
    	int n = graph.length;
    	int min = Integer.MAX_VALUE;
    	boolean[][] visited = new boolean[1 << n][n];
    	int[][] cache = new int[1 << n][n];
    	
    	for (int i = 0; i < (1 << n); i++)
    		Arrays.fill(cache[i], -1);
    	
    	for (int i = 0; i < n; i++)			//Start from each node and find the shortest path
    		min = Math.min(min, dfs(graph, visited, cache, i, n, 1 << i));

    	return min;
    }
    
    int dfs(int[][] graph, boolean[][] visited, int[][] cache, int src, int n, int status)
    {
    	if (status == (1 << n) - 1)
    		return 0;
    	
    	if (cache[status][src] != -1)
    		return cache[status][src];
    	
    	int shortest = Integer.MAX_VALUE;
    	
    	for (int nei : graph[src])
    	{
    		int updStatus = status | (1 << nei);
    		
    		if (!visited[updStatus][nei])	//If we haven't calculated this status before, search the shortest path
    		{
    			visited[updStatus][nei] = true;
    			
    			int dist = dfs(graph, visited, cache, nei, n, updStatus);
    			if (dist != -1)
    				shortest = Math.min(shortest, dist + 1);
    			
    			visited[updStatus][nei] = false;
    		}
    	}
    	
    	if (shortest == Integer.MAX_VALUE)
    		return -1;
    	
		cache[status][src] = shortest;
		return cache[status][src];
    }

    public static void main(String[] args) 
	{
		ShortestPathVisitingAllNodes obj = new ShortestPathVisitingAllNodes();
		int[][] graph = new int[][] {{1,2,3},{0},{0},{0}};
		System.out.println(obj.shortestPathLength(graph));
		
		graph = new int[][] {{1},{0,2,4},{1,3,4},{2},{1,2}};
		System.out.println(obj.shortestPathLength(graph));
	}
}
