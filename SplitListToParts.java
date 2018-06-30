public class SplitListToParts 
{
    public ListNode[] splitListToParts(ListNode root, int k) 
    {
        ListNode[] result = new ListNode[k];
        int len = getLength(root);
        
        int n = len / k;    // minimum number of guaranteed part size
        int r = len % k;    // extra nodes spread to the first r parts
        int i = 0;
        ListNode curr = root;
        ListNode prev = null;
        
        while (curr != null)
        {
            result[i] = curr;
            
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++)
            {                
                prev = curr;
                curr = curr.next;
            }
            
            prev.next = null;
            r--;
            i++;
        }
        return result;
    }
    
    int getLength(ListNode node)
    {
        int len = 0;        
        while(node != null)
        {
            node = node.next;
            len++;            
        }        
        return len;
    }

    public static void main(String[] args)
    {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        
        SplitListToParts obj = new SplitListToParts();
        obj.splitListToParts(root, 2);
    }
}
