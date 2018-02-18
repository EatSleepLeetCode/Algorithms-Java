import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinK 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int K) 
    {
        int cheapest = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> edgeMap = new HashMap<Integer, List<int[]>>();
        
        for(int i = 0; i < flights.length; i++)
        {
            int srcNode = flights[i][0];
            int destNode = flights[i][1];
            int price = flights[i][2];
            
            if(!edgeMap.containsKey(srcNode))
            {
                edgeMap.put(srcNode, new ArrayList<int[]>());
            }
            edgeMap.get(srcNode).add(new int[]{destNode, price});
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{src, 0});
        K= K + 1;                        //Increase K by 1 to offset the starting state
        
        while(!q.isEmpty() && K >= 0)
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                int node = curr[0];
                int price = curr[1];

                if(node == dest)        //If we reach dest node then we don't need to add its neighbors
                {
                    cheapest = Math.min(cheapest, price);
                    continue;
                }

                List<int[]> neighbors = edgeMap.get(node);

                if(neighbors != null)
                {
                    for(int[] neighbor : neighbors)
                    {
                        //If cost is >= cheapest then no need to add it to q
                        if(neighbor[1] + price < cheapest)
                            q.offer(new int[]{neighbor[0], neighbor[1] + price});
                    }
                }
            }
            K--;
        }
        
        if(cheapest == Integer.MAX_VALUE)
            return -1;
        
        return cheapest;
    }
	public static void main(String[] args) 
	{
		CheapestFlightsWithinK obj = new CheapestFlightsWithinK();
		System.out.println(obj.findCheapestPrice(3, new int[][] {{0, 1, 100},{1, 2, 100},{0, 2, 500}}, 0, 2, 1));

	}

}
