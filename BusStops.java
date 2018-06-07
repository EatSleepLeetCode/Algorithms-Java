import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusStops 
{
    public int numBusesToDestination(int[][] routes, int S, int T) 
    {
        int n = routes.length;
        int result = 0;        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();    
        
        for(int i = 0; i < n; i++)      //Set up stop to buses map
        {
            for(int stop : routes[i])
            {
                map.putIfAbsent(stop, new ArrayList<Integer>());
                map.get(stop).add(i);
            }
        }
        
        if(S == T) return 0;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visitedBuses = new HashSet<Integer>();
        Set<Integer> visitedStops = new HashSet<Integer>();
        
        queue.offer(S);
        visitedStops.add(S);
        
        while(!queue.isEmpty())
        {
            result++;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int curr = queue.poll();
                
                for(int bus : map.get(curr))
                {
                    if(visitedBuses.contains(bus))
                        continue;
                    
                    for(int stop : routes[bus])
                    {
                        if(visitedStops.contains(stop))
                            continue;
                        
                        if(stop == T)
                            return result;
                        
                        queue.offer(stop);
                        visitedStops.add(stop);
                        visitedBuses.add(bus);
                    }
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) 
	{
		BusStops obj = new BusStops();
		System.out.println(obj.numBusesToDestination(new int[][] {{2}, {2,8}}, 2, 8));
	}
}
