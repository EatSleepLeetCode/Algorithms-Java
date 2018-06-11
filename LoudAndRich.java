import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class LoudAndRich 
{
    //Solution 1 - Using Topological sort from each person - Inefficient
    public int[] loudAndRich1(int[][] richer, int[] quiet) 
    {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        int n = quiet.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<Integer>());
        
        for (int i = 0; i < richer.length; i++)
            adj.get(richer[i][1]).add(richer[i][0]);
        
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, List<Integer>> topoMap = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < n; i++)
        {
        	visited.clear();
            
            dfsTopo(adj, visited, i, stack);
            
            topoMap.put(i, new ArrayList<Integer>());
            while (!stack.isEmpty())
            {
        		topoMap.get(i).add(stack.pop());            
            }
            
            List<Integer> temp = new ArrayList<Integer>(topoMap.get(i));
            Collections.sort(temp, (a, b) -> quiet[a] - quiet[b]);
            if (temp.size() > 0)
            	answer[i] = temp.get(0);
            else
            	answer[i] = i;
        }
        return answer;
    }
    
    void dfsTopo(Map<Integer, List<Integer>> adj, Set<Integer> visited, int src, Stack<Integer> stack)
    {
        visited.add(src);
        
        List<Integer> adjList = adj.get(src);
        
        if (adjList != null)
        {
            for (int person : adjList)
            {
                if (visited.contains(person))
                    continue;
                
                dfsTopo(adj, visited, person, stack);
            }
        }            
        stack.push(src);                            
    }
    
    //Solution 2 - Using cached DFS for each person
    public int[] loudAndRich2(int[][] richer, int[] quiet) 
    {
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        int n = quiet.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < n; i++)
        {
            adj.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < richer.length; i++)
        {            
            adj.get(richer[i][1]).add(richer[i][0]);
        }
        
        for (int i = 0; i < n; i++)
        {
            dfs(adj, i, quiet, answer);
        }
        return answer;
    }
    
    int dfs(Map<Integer, List<Integer>> adj, int src, int[] quiet, int[] answer)
    {
        if (answer[src] >= 0)
        {
            return answer[src];
        }
        
        answer[src] = src;
            
        List<Integer> adjList = adj.get(src);
        
        if (adjList != null)
        {
            for (int person : adjList)
            {
                int candidate = dfs(adj, person, quiet, answer);

                if (quiet[answer[src]] > quiet[candidate])
                    answer[src] = candidate;                                
            }            
        }        

        return answer[src];
    }
    
    public int[] loudAndRich(int[][] richer, int[] quiet)
    {
    	int n = quiet.length;
    	int[] answer = new int[n];
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int[] richerCount = new int[n];
    	List<Integer>[] dependencyGraph = new List[n];    	
    	
    	for (int i = 0; i < n; i++)
    	{
    		dependencyGraph[i] = new ArrayList<Integer>();
    	}
    	
    	for (int i = 0; i < richer.length; i++)
    	{
    		richerCount[richer[i][1]]++;
    		dependencyGraph[richer[i][0]].add(richer[i][1]);
    	}
    	
    	for (int i = 0; i < n; i++)
    	{
    		answer[i] = i;
    		
    		if (richerCount[i] == 0)
    		{
    			queue.offer(i);
    		}
    	}
    	
    	while (!queue.isEmpty())
    	{
    		int curr = queue.poll();
    		
    		List<Integer> peoplePoorer = dependencyGraph[curr];
    		
    		for (int person : peoplePoorer)
    		{
    			richerCount[person]--;
    			if (richerCount[person] == 0)
    			{
    				queue.offer(person);
    			}
    			
				if (quiet[answer[person]] > quiet[answer[curr]])
				{
					answer[person] = answer[curr];
				}
    		}    		
    	}
    	return answer;
    }
    
    
	public static void main(String[] args) 
	{
		LoudAndRich obj = new LoudAndRich();
		
		obj.loudAndRich(new int[][] {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[] {3,2,5,4,6,1,7,0});
	}
}
