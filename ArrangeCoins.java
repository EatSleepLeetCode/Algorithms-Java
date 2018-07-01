
public class ArrangeCoins 
{
    public int arrangeCoins(int n) 
    {
        if (n == 0) return 0;
        int count = 1;
        
        while (true)
        {
            n -= count;

            if (n < 0)
            {
                break;
            }
            
            count++;
        }
        return count - 1;
    }
}
