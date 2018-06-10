import java.util.HashSet;
import java.util.Set;

public class CardFillipingGame 
{
    public int flipgame(int[] fronts, int[] backs) 
    {
        int n = fronts.length;
        int result = Integer.MAX_VALUE;
        Set<Integer> sameValsSet = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++)
        {
            if (fronts[i] == backs[i])
            {
                sameValsSet.add(fronts[i]);
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (!sameValsSet.contains(fronts[i]))
            {
                result = Math.min(result, fronts[i]);
            }
            if (!sameValsSet.contains(backs[i]))
            {
                result = Math.min(result, backs[i]);
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
