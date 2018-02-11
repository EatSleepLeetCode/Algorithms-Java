import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Rabbits 
{
    public int numRabbits(int[] answers) 
    {
        int count = 0;        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int ans : answers)
        {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        
        for(int ans : map.keySet())
        {
            int ansCount = map.get(ans);
            
            if(ans < ansCount)
            {
            	while(ansCount > 0)
            	{
            		count = count + ans + 1;
            		ansCount = ansCount - ans - 1;
            	}
            }
            else
            {
            	count = count + ans + 1;
            }            
        }
        
        return count;
    }
	public static void main(String[] args) 
	{
		Rabbits obj = new Rabbits();
		System.out.println(obj.numRabbits(new int[] {0,0,0,1,1}));
		System.out.println(obj.numRabbits(new int[] {10,10,10}));

	}

}
