import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe 
{
    public String crackSafe(int n, int k) 
    {
        Set<String> visited = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        int target = (int)Math.pow(k, n);
        
        if (n == 1 && k == 1)
            return "0";        
        
        for (int i = 0; i < n; i++)
            sb.append("0");
        
        visited.add(sb.toString());
        
        dfs(n, k, target, visited, sb);
        
        return sb.toString();
    }
    
    boolean dfs(int n, int k, int target, Set<String> visited, StringBuilder sb)
    {
        if (visited.size() == target)
            return true;
        
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        
        for (int i = 0; i < k; i++)
        {
            String nei = prev + i;
            
            if (visited.contains(nei))
                continue;
            
            sb.append(i);                                       //append i
            
            visited.add(nei);
            
            if (dfs(n, k, target, visited, sb))
            {
                return true;
            }
            else
            {
                visited.remove(nei);
                sb.delete(sb.length() - 1, sb.length());        //sb.deleteCharAt(sb.length() - 1,) also works
            }
        }
        return false;
    }
    
	public static void main(String[] args) 
	{
		CrackingTheSafe obj = new CrackingTheSafe();
		System.out.println(obj.crackSafe(2, 2));
	}
}
