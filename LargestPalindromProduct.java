
public class LargestPalindromProduct 
{
    public int largestPalindrome(int n) 
    {
        // if input is 1 then max is 9 
        if(n == 1)
            return 9;
        // if n = 3 then upperBound = 999 and lowerBound = 100
        int upperBound = (int) Math.pow(10, n) - 1;
        int lowerBound = (int) Math.pow(10, n - 1);
        
        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        long maxNumPossible = (long) upperBound * (long) upperBound;
        long firstHalf = maxNumPossible / (long) Math.pow(10, n);
        boolean found = false;
        long palindrome = 0;
            
        while(!found)
        {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrome = createPalindrome(firstHalf);
            
            // here i and palindrom/i forms the two factor of assumed palindrom
            for(long i = upperBound; i >= lowerBound; i--)
            {
                 // if n= 3 none of the factor of palindrom  can be more than 999 
                 // or less than square root of assumed palindrom                 
               
                if((palindrome / i > maxNumPossible) || (palindrome > i * i))
                    break;
                 
                // if two factors found, where both of them are n-digits,
                
                if(palindrome % i == 0)
                {
                    found = true;
                    break;
                }
            }
            
            firstHalf--;
        }        
        return (int) (palindrome % 1337);
    }
    
    long createPalindrome(long firstHalf)
    {
        String strFirstHalf = String.valueOf(firstHalf);
        String strSecondHalf = new StringBuilder(strFirstHalf).reverse().toString();        
        return Long.parseLong(strFirstHalf + strSecondHalf);
    }
    
    public static void main(String[] args)
    {
    	LargestPalindromProduct obj = new LargestPalindromProduct();
    	System.out.println(obj.largestPalindrome(6));
    }
}
