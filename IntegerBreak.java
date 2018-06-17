
public class IntegerBreak 
{
    public int integerBreak(int n) 
    {
        int product = 1;
        
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        while (n > 4)       //Notice it's n > 4 and not n >= 4
        {
            product *= 3;
            n -= 3;
        }
        
        return product * n;
    }
}
