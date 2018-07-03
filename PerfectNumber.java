class PerfectNumber
{
    public boolean checkPerfectNumber(int num) 
    {
        if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if ( num % i == 0)
            {
                sum += i;
                
                if (num / i != i)
                {
                    sum += num / i;
                }
            }
        }
        sum++;                      //every number is divisible by 1
        
        return num == sum;
    }
}
