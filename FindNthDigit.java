public class FindNthDigit
{
    public int findNthDigit(int n) 
    {
        //Step 1 - Calculate how many digits the number has.
        
        long base = 9;
        long digits = 1;
        
        while (n - base * digits > 0)
        {
            n -= base * digits;
            base *= 10;
            digits++;
        }
        
        //Step 2 - Calculate what the number is.
        
        long index = n % digits;
        if (index == 0)
            index = digits;
        
        long num = 1;
        for (int i = 1; i < digits; i++)
        {
            num *= 10;
        }
        
        num += (index == digits) ? n / digits - 1 : n / digits;
        
        //Step 3 - Find out which digit in the number do we want.
        
        for (long i = index; i < digits; i++)
        {
            num /= 10;            
        }
        return (int)num % 10;
    }
}
