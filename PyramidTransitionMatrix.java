import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix 
{
    public boolean pyramidTransition(String bottom, List<String> allowed) 
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : allowed)
        {
            String key = str.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str.substring(2));            
        }
        return helper(bottom, map);
    }
    
    boolean helper(String bottom, Map<String, List<String>> map)
    {
        if (bottom.length() == 1)
            return true;
        
        for (int i = 0; i < bottom.length() - 1; i++)       // -1
        {
            if (!map.containsKey(bottom.substring(i, i + 2)))
                return false;
        }
        
        List<String> ls = new ArrayList<String>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String str : ls)
        {
            if (helper(str, map))
                return true;
        }
        return false;
    }
    
    void getList(String bottom, int index, StringBuilder sb, List<String> ls, Map<String, List<String>> map)
    {
        if (index == bottom.length() - 1)
        {
            ls.add(sb.toString());
            return;
        }
        
        for (String str : map.get(bottom.substring(index, index + 2)))
        {
            sb.append(str);
            getList(bottom, index + 1, sb, ls, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
	public static void main(String[] args) 
	{
		PyramidTransitionMatrix obj = new PyramidTransitionMatrix();
		System.out.println(obj.pyramidTransition("XYZ", Arrays.asList(new String[]{"XYD", "YZE", "DEA", "FFF"})));;
	}
}
