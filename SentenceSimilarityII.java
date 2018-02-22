import java.util.HashSet;
import java.util.Set;

public class SentenceSimilarityII 
{
	boolean areSentencesSimilarTwo(String[] words1, String[] words2,String[][] pairs)
	{
		int n1 = words1.length;
		int n2 = words2.length;
		
		if(n1 != n2)
			return false;
		
		GraphUnDirected graph = new GraphUnDirected();
		
		for(String[] pair : pairs)
		{
			graph.addEdge(pair[0], pair[1]);
		}
		
		for(int i = 0; i < n1; i++)
		{
			Set<String> visited = new HashSet<String>();
			
			String word1 = words1[i];
			String word2 = words2[i];
			
			if(word1.equals(word2))
				continue;
			
			if(!dfs(graph, visited, word1, word2))
				return false;
		}
		return true;
	}
	
	boolean dfs(GraphUnDirected graph, Set<String> visited, String src, String dest)
	{
		visited.add(src);
		
		Set<String> adjList = graph.adj.get(src);
		
		if(adjList != null)
		{
			if(adjList.contains(dest))
				return true;
			
			for(String neighbor : adjList)
			{
				if(!visited.contains(neighbor) && dfs(graph, visited, neighbor, dest))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		SentenceSimilarityII obj = new SentenceSimilarityII();
		String[] words1 = new String[] {"great", "acting", "skills"};
		String[] words2 = new String[] {"fine", "drama", "talent"};
		String[][] pairs = new String[][] {{"great", "good"},{"fine", "good"},{"acting", "drama"},{"skills", "talent"}};
		
		System.out.println(obj.areSentencesSimilarTwo(words1, words2, pairs));
	}
}
