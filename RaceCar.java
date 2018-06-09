import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar 
{
    public int racecar(int target) 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0, 1));                             // starts from position 0 with speed 1

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);

        int depth = -1;
        
        while (!queue.isEmpty()) 
        {
            depth++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++) 
            {
                Node curr = queue.poll();                        // cur[0] is position; cur[1] is speed

                if (curr.pos == target) 
                {
                    return depth;
                }

                Node nei = new Node(curr.pos + curr.speed, curr.speed << 1);   // accelerate instruction
                String neiKey = (nei.pos + " " + nei.speed);

                if (!visited.contains(neiKey) && 0 < nei.pos && nei.pos < (target << 1)) 
                {
                    queue.offer(nei);
                    visited.add(neiKey);
                }

                nei = new Node(curr.pos, curr.speed > 0 ? -1 : 1);            // reverse instruction
                neiKey = (nei.pos + " " + nei.speed);

                if (!visited.contains(neiKey) && 0 < nei.pos && nei.pos < (target << 1)) 
                {
                    queue.offer(nei);
                    visited.add(neiKey);
                }
            }
        }
        return -1;
    }

	public static void main(String[] args) 
	{		
		RaceCar obj = new RaceCar();
		System.out.println(obj.racecar(3));
	}
}

class Node
{
	int pos;
	int speed;
	
	public Node(int pos, int speed)
	{
		this.pos = pos;
		this.speed = speed;
	}
}