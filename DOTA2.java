import java.util.LinkedList;
import java.util.Queue;

public class DOTA2 
{
    public String predictPartyVictory(String senate) 
    {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<Integer>();
        Queue<Integer> dQueue = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++)
        {
            char ch = senate.charAt(i);
            if (ch == 'R') rQueue.offer(i);
            if (ch == 'D') dQueue.offer(i);
        }
        
        while (!rQueue.isEmpty() && !dQueue.isEmpty())
        {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            
            if (rIndex < dIndex)
                rQueue.offer(rIndex + n);
            else
                dQueue.offer(dIndex + n);
        }
        
        return rQueue.size() > dQueue.size() ? "Radiant" : "Dire";
    }
}
