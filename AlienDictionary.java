import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary 
{
	public String alienOrder(String[] words) 
	{
	    Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
	    int[] visited = new int[26];
	    
	    buildGraph(words, adj, visited);
	
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < 26; i++) 
	    {
	        if(visited[i] == 0)						// 0 = unvisited 
	        {                 
	            if(!dfs(adj, visited, sb, i))
	            {
	            	return "";
	            }
	        }
	    }
	    return sb.reverse().toString();
	}
	
	public boolean dfs(Map<Integer, Set<Integer>> adj, int[] visited, StringBuilder sb, int i) 
	{
	    visited[i] = 1;                            	// 1 = visiting
	    
	    if(adj.containsKey(i))
	    {
		    Set<Integer> adjList = adj.get(i);
		    
		    for(int j : adjList) 
		    {
		    	if(visited[j] == 2)					//2 => completed already
		    		continue;
		    	
	            if(visited[j] == 1)				   	// 1 => cycle 
	            	return false;     
	                          
                if(!dfs(adj, visited, sb, j))		//only check if visited state is 0 i.e. in white set
                {
                	return false;
                }
		    }
	    }
	    visited[i] = 2;                           	// 2 = visited
	    sb.append((char) (i + 'a'));
	    return true;
	}
	
	public void buildGraph(String[] words, Map<Integer, Set<Integer>> adj, int[] visited) 
	{
	    Arrays.fill(visited, -1);                 	// -1 = not even existed
	    
	    for(int i = 0; i < words.length; i++) 
	    {
	        for(char c : words[i].toCharArray())
	        {
	        	visited[c - 'a'] = 0;
	        }
	        	
	        if(i > 0) 
	        {
	            String w1 = words[i - 1];
	            String w2 = words[i];
	            int len = Math.min(w1.length(), w2.length());
	            
	            for(int j = 0; j < len; j++) 
	            {
	                int c1 = w1.charAt(j) - 'a';
	                int c2 = w2.charAt(j) - 'a';
	                
	                if(c1 != c2) 
	                {
	                	if(!adj.containsKey(c1))
	                	{
	                		adj.put(c1, new HashSet<Integer>());
	                	}
	                	
	                	adj.get(c1).add(c2);
	                    break;
	                }
	            }
	        }
	    }
	}
	
	public static void main(String[] args)
	{
		AlienDictionary obj = new AlienDictionary();
		String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
		System.out.println(obj.alienOrder(words));
	}
}