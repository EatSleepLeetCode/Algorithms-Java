import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BullsAndCows 
{
    public String getHint(String secret, String guess) 
    {
        Map<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>();
        int n = secret.length();
        int[] nums = new int[10];
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < n; i++)
        {
            int s = (int)(secret.charAt(i) - '0');
            int g = (int)(guess.charAt(i) - '0');

            if (s == g)
            {
                bulls++;                
            }
            else
            {
                if (nums[s] < 0)  cows++; 
                nums[s]++;                      //tricky
                
                if (nums[g] > 0) cows++;
                nums[g]--;                      //tricky
            }
        }
        return bulls + "A" + cows + "B";
    }
}
