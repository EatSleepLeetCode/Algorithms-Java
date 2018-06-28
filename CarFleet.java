import java.util.Map;
import java.util.TreeMap;

public class CarFleet 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        double curr = 0;
        int count = 0;
        Map<Integer, Double> map = new TreeMap<Integer, Double>();
        
        //doing -pos[i] to store values in sorted order
        for (int i = 0; i < position.length; i++)
            map.put(-position[i], (double)(target - position[i]) / speed[i]);
        
        for (Double val : map.values())
        {
            if (val > curr)
            {
                curr = val;
                count++;
            }
        }

        return count;
    }
}
