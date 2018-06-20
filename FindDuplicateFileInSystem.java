import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem 
{
    public List<List<String>> findDuplicate(String[] paths) 
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String path : paths)
        {
            String[] values = path.split(" ");                          //value[0] is dir
            for (int i = 1; i < values.length; i++)
            {
                String[] nameContent = values[i].split("\\(");          //nameContent[0] is name of a file
                nameContent[1] = nameContent[1].replace(")", "");       //nameContent[1] is content of a file
                
                List<String> list = map.getOrDefault(nameContent[1], new ArrayList<String>());
                list.add(values[0] + "/" + nameContent[0]);
                map.put(nameContent[1], list);
            }
        }
        
        List<List<String>> resultMap = new ArrayList<List<String>>();
        for (String key : map.keySet())
        {
            if (map.get(key).size() > 1)
                resultMap.add(map.get(key));
        }
        return resultMap;
    }
}
