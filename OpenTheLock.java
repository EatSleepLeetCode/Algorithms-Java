import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class OpenTheLock 
{
    public int openLock(String[] deadends, String target) 
    {
        Set<String> dead = new HashSet<String>();
        for(String deadend : deadends)
        {
            dead.add(deadend);
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        
        Set<String> seen = new HashSet<String>();
        seen.add("0000");
        
        int depth = 0;
        
        while(!queue.isEmpty())
        {
        	depth++;
        	int size = queue.size();
        	
        	for(int i = 0; i < size; i++)
        	{
                String curr = queue.poll();
                
                if(!dead.contains(curr))
                {
                    for(int pos = 0; pos < 4; pos++)
                    {
                        for(int dir = -1; dir <= 1; dir = dir + 2)
                        {
                            int updPos = (int)(curr.charAt(pos) - '0' + dir + 10) % 10;
                            String nei = curr.substring(0, pos) + updPos + curr.substring(pos + 1);
                            
                            if(nei.equals(target))
                                return depth;
                            
                            if(!seen.contains(nei))
                            {
                                seen.add(nei);
                                queue.offer(nei);
                            }
                        }
                    }
                }
        	}
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
    	OpenTheLock obj = new OpenTheLock();
    	String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
    	String target = "0202";
    	System.out.println(obj.openLock(deadends, target));
    }
}