import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString 
{
    public int uniqueLetterString(String S) 
    {
        long result = 0;
        Map<Character, List<Integer>> posMap = new HashMap<Character, List<Integer>>();
        
        for (int i = 0; i < S.length(); i++)
        {
            posMap.computeIfAbsent(S.charAt(i), x -> new ArrayList<Integer>()).add(i);  //Notice syntax, add is outside
        }
        
        for (List<Integer> vals : posMap.values())
        {
            for (int i = 0; i < vals.size(); i++)
            {
                long prev = i > 0 ? vals.get(i - 1) : -1;
                long next = i < vals.size() - 1 ? vals.get(i + 1) : S.length();
                result += ((vals.get(i) - prev) * (next - vals.get(i)));
            }
        }
        return (int) (result % Math.pow(10, 7));
    }
}
