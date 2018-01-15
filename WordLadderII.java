import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII 
{
    public List<List<String>> findLadders(String start, String end, List<String> wordList) 
    {
       HashSet<String> dict = new HashSet<String>(wordList);
       List<List<String>> res = new ArrayList<List<String>>();         
       
        HashMap<String, ArrayList<String>> nodeNeighbors = 
           new HashMap<String, ArrayList<String>>();// Neighbors for every node
       
        HashMap<String, Integer> distance = 
           new HashMap<String, Integer>();// Distance of every node from the start node
       ArrayList<String> solution = new ArrayList<String>();

       dict.add(start);          
       bfs(start, end, dict, nodeNeighbors, distance);                 
       dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
       return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, 
                     ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) 
    {
      for (String str : dict)
          nodeNeighbors.put(str, new ArrayList<String>());

      Queue<String> queue = new LinkedList<String>();
      queue.offer(start);
      distance.put(start, 0);

      while (!queue.isEmpty()) 
      {
          int count = queue.size();
          boolean foundEnd = false;

          for (int i = 0; i < count; i++) 
          {
              String cur = queue.poll();
              int curDistance = distance.get(cur);                
              ArrayList<String> neighbors = getNeighbors(cur, dict);

              for (String neighbor : neighbors) 
              {
                  nodeNeighbors.get(cur).add(neighbor);
                  if (!distance.containsKey(neighbor)) // Check if visited
                  {
                      distance.put(neighbor, curDistance + 1);

                      if (end.equals(neighbor))// Found the shortest path
                          foundEnd = true;
                      else
                          queue.offer(neighbor);
                      }
                  }
              }

              if (foundEnd)
                  break;
          }
      }

    // Find all next level nodes.    
    private ArrayList<String> getNeighbors(String node, Set<String> dict) 
    {
      Set<String> res = new HashSet<String>();

      for (int i = 0; i < node.length(); i++) 
      {          
          char[] chs = node.toCharArray();
          
          for (char ch ='a'; ch <= 'z'; ch++) 
          {
              if (chs[i] == ch) 
                  continue;
              chs[i] = ch;
              
              if (dict.contains(String.valueOf(chs))) 
              {
                  res.add(String.valueOf(chs));
              }
          }
      }
      return new ArrayList<String>(res);
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, 
                     HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) 
    {
        solution.add(cur);
        if (end.equals(cur)) 
        {
           res.add(new ArrayList<String>(solution));
        } 
        else 
        {
           for (String next : nodeNeighbors.get(cur)) 
           {            
                if (distance.get(next) == distance.get(cur) + 1) 
                {
                     dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }           
       solution.remove(solution.size() - 1);
    }
    
    public static void main(String[] args)
    {
    	WordLadderII obj = new WordLadderII();
    	obj.findLadders("hit", "cog", new ArrayList<String>(Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"})));
    }
}