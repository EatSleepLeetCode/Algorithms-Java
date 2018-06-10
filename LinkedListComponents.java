import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents 
{
    public int numComponents(ListNode head, int[] G) 
    {
        int count = 0;
        Set<Integer> gSet = new HashSet<Integer>();
        
        for (int val : G)
        {
            gSet.add(val);
        }
        
        ListNode curr = head;
        
        while (curr != null)
        {
            if (gSet.contains(curr.val) && (curr.next == null || !gSet.contains(curr.next.val)))
            {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }
}

class ListNode 
{
	int val;
	ListNode next;
	
    ListNode(int x) 
    { 
    	val = x; 
	}
}