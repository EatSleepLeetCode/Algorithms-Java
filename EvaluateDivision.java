import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision 
{
    Map<String, Map<String, Double>> map;
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) 
    {
        map = new HashMap<String, Map<String, Double>>();
        
        for (int i = 0; i < equations.length; i++)
        {
            String[] equation = equations[i];            
            map.putIfAbsent(equation[0], new HashMap<String, Double>());
            map.get(equation[0]).put(equation[1], values[i]);
            map.putIfAbsent(equation[1], new HashMap<String, Double>());
            map.get(equation[1]).put(equation[0], 1 / values[i]);
        }
        
        double[] result = new double[queries.length];
        
        for (int i = 0; i < queries.length; i++)
        {
            String[] query = queries[i];
            Set<String> visited = new HashSet<String>();
            result[i] = dfs(query[0], query[1], visited, 1);
        }        
        return result;
    }
    
    double dfs(String source, String target, Set<String> visited, double value)
    {        
        if (!map.containsKey(source))       //e.g. x, x
            return -1;
        
        visited.add(source);
        
        if (source.equals(target))
            return value;
        
        Map<String, Double> neiMap = map.get(source);
        
        if (neiMap != null)
        {
            for (Map.Entry<String, Double> entry : neiMap.entrySet())
            {
                String neiNode = entry.getKey();
                if (visited.contains(neiNode))
                    continue;
                
                double neiValue = entry.getValue();
                double result = dfs(neiNode, target, visited, value * neiValue);
                
                if (result != -1)
                    return result;                
            }
        }        
        return -1;
    }
}
