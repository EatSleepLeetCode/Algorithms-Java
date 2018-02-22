import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillAProcess 
{
	List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill)
	{	
		if(kill == 0)
			return pid;
		
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
		int n = pid.size();
		
		for(int i = 0; i < n; i++)
		{
			int parentProcess = ppid.get(i);
			int childProcess = pid.get(i);
			
			if(!tree.containsKey(parentProcess))
			{
				tree.put(parentProcess, new ArrayList<Integer>());
			}
			tree.get(parentProcess).add(childProcess);
		}
		
		dfs(result, tree, kill);
		
		return result;
	}
	
	void dfs(List<Integer> result, Map<Integer, List<Integer>> tree, int kill)
	{
		result.add(kill);
		List<Integer> children = tree.get(kill);
		
		if(children != null)
		{
			for(int child : children)
			{
				dfs(result, tree, child);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		KillAProcess obj = new KillAProcess();
		List<Integer> pid = new ArrayList<Integer>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);

		List<Integer> ppid = new ArrayList<Integer>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);

		System.out.println(obj.killProcess(pid, ppid, 0));
	}
}
