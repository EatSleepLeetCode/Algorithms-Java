
public class SuperUglyNumber 
{
    public int nthSuperUglyNumber(int n, int[] primes) 
    {
        if (n < 0)  return -1;
        if (n == 1) return 1;        
        int[] ugly = new int[n];
        
        int len = primes.length;
        int[] index = new int[len];
        
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++)
        {
            int min = Integer.MAX_VALUE;
            
            for (int j = 0; j < len ; j++)
            {
                min = Math.min(min, ugly[index[j]] * primes[j]);
            }
            
            ugly[i] = min;
            
            for (int j = 0; j < len ; j++)
            {
                if (ugly[i] == ugly[index[j]] * primes[j])
                {
                    index[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
