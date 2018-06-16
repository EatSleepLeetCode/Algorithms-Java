import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary 
{
    public List<String> findItinerary(String[][] tickets) 
    {
        List<String> result = new ArrayList<String>();
        Map<String, PriorityQueue<String>> adj = new HashMap<String, PriorityQueue<String>>();
        
        for (String[] ticket : tickets)
        {
            adj.putIfAbsent(ticket[0], new PriorityQueue<String>());
            adj.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("JFK", adj, result);
        return result;
    }
    
    void dfs(String departure, Map<String, PriorityQueue<String>> adj, List<String> result)
    {
        PriorityQueue<String> arrivalsPQ = adj.get(departure);
        
        if (arrivalsPQ != null)
        {
            while (!arrivalsPQ.isEmpty())
            {
                String city = arrivalsPQ.poll();
                dfs(city, adj, result);
            }
        }
        result.add(0, departure);                   //Add to front
    }

    public static void main(String[] args)
    {
    	ReconstructItinerary obj = new ReconstructItinerary();
    	System.out.println(obj.findItinerary(new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
    }

}
