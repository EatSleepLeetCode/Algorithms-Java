import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstras 
{
	List<Integer> shortestPath(int[][] edges, int src)
	{
		Map<Integer, List<int[]>> edgeMap = new HashMap<Integer, List<int[]>>();
		
		for(int[] edge : edges)
		{
			if(!edgeMap.containsKey(edge[0]))
			{
				edgeMap.put(edge[0], new ArrayList<int[]>());
			}
			edgeMap.get(edge[0]).add(new int[] {edge[1], edge[2]});
		}
		
		Map<Integer, Integer> distMap = new HashMap<Integer, Integer>();
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2)
			{
				return e1[1] - e2[1];
			}
		});
		
		pq.offer(new int[] {src, 0});
		
		while(!pq.isEmpty())
		{
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDelay = curr[1];
			
			if(distMap.containsKey(currNode))
			{
				continue;
			}
				
			distMap.put(currNode, currDelay);
			
			if(edgeMap.containsKey(currNode))
			{
				for(int[] neighbor : edgeMap.get(currNode))
				{
					int neighborNode = neighbor[0];
					int neighborDelay = neighbor[1];
					
					if(!distMap.containsKey(neighborNode))
					{
						pq.offer(new int[] {neighborNode, neighborDelay + currDelay});
					}
				}
			}
		}
		
		return new ArrayList<Integer>(distMap.values());
	}
	
	public static void main(String[] args) 
	{
		Dijkstras obj = new Dijkstras();
		int[][] edges = new int[][] {{1,2,1},{1,3,4},{2,3,2}};
		
		System.out.println(obj.shortestPath(edges, 1));
	}

}
