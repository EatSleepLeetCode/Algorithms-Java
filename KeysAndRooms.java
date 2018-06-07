import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms 
{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        dfs (rooms, 0, visited);
        
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
                return false;
        }
        return true;
    }
    
    void dfs(List<List<Integer>> rooms, int src, boolean[] visited)
    {
        visited[src] = true;
        
        for(int key : rooms.get(src))
        {
            if(visited[key])
                continue;
            
            dfs(rooms, key, visited);            
        }
    }
	public static void main(String[] args) 
	{
		KeysAndRooms obj = new KeysAndRooms();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(3));
		rooms.add(Arrays.asList());
		System.out.println(obj.canVisitAllRooms(rooms));
	}
}
