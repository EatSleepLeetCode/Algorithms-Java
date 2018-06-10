import java.util.ArrayList;
import java.util.List;

public class PositionOfLargeGroups 
{
    public List<List<Integer>> largeGroupPositions(String S) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = S.length();
        int i = 0;
        int startIndex = 0;
        int count = 0;
        
        while (i < n)
        {
            count = 0;
            char ch = S.charAt(i);
            startIndex = i;
            
            while (i < n && ch == S.charAt(i))
            {
                i++;
                count++;
            }
            
            if (count >= 3)
            {
                result.add(new ArrayList<Integer>());
                result.get(result.size() - 1).add(startIndex);
                result.get(result.size() - 1).add(startIndex + count - 1);
            }
        }
        return result;
    }  
}
