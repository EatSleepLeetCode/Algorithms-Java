import java.util.HashMap;
import java.util.Map;

public class CanIWin 
{
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) 
    {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;    //sum = n * (n + 1) / 2        

        if (desiredTotal <= 0)  return true;
        if (sum  < desiredTotal)    return false;
        return helper(desiredTotal, map, used);
    }
    
    boolean helper(int desiredTotal, Map<Integer, Boolean> map, boolean[] used)
    {
        if (desiredTotal <= 0)
            return false;
        
        int key = format(used);
        
        if (map.containsKey(key))
            return map.get(key);
        
        for (int i = 1; i < used.length; i++)       //i starts from 1
        {            
            if (!used[i])                           // try every unchosen number as next step
            {
                used[i] = true;
                
                if (!helper(desiredTotal - i, map, used)) // check whether this lead to a win (i.e. the other player lose)
                {
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                else
                {
                    used[i] = false;
                }
            }
        }
        map.put(key, false);
        return false;
    }
    
    // Convert boolean[] to an Integer
    int format(boolean[] used)
    {
        int num = 0;
        for (int i = 0; i < used.length; i++)
        {
            num = num << 1;
            if (used[i]) num = num | 1;
        }
        return num;
    }
}
