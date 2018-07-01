import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs 
{
    public int numberOfBoomerangs(int[][] points) 
    {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int[] i : points)
        {
            for (int[] j : points)
            {
                if (i == j)
                    continue;
                int dist = getDist(i, j);
                
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            
            for (int val : map.values())
            {
                result += val * (val - 1);
            }
            map.clear();                                //important
        }
        return result;
    }
    
    int getDist(int[] i, int[] j)
    {
        int x = i[0] - j[0];                            
        int y = i[1] - j[1];
                                    //using euclidean distance bcoz manhattan dist
        return x * x + y * y;       //wasn't working correctly due to -ve co-ordinates
    }
}
