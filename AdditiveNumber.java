
public class AdditiveNumber 
{
     /**
         * Iterate over possible first numbers.
         * The first number is defined as num.substring(0, i), inclusive of 0, and exclusive of i.
         * Note that the first number, when added to a second number of any length, must produce 
         * a sum that is at least the length of the first number.
         * Accordingly, the first number cannot be more than half the length of the given String num.
         * Accordingly, we can stop iterating when i reaches (n / 2) + 1.
         * Note also that when num.length < 2, this loop exits, thus handling some of the invalid-length inputs.
         *
         * Iterate over possible second numbers.
         * The second number is defined as num.substring(i, i + j), inclusive of i, and exclusive of i + j.
         * Note that the second number, when added to a first number of any length, must produce a sum whose
         * length is at least the maximum of either i or j.
         * Accordingly, if n is the length of the given num, and i of those digits belong to the first number,
         * and j of those digits belong to the second number, then (n - i - j) digits are left for the sum.
         * Since length of sum is at least max(i, j), we can stop iterating when max(i, j) exceeds n - i - j.
         */    
    public boolean isAdditiveNumber(String num) 
    {
        int n = num.length();
        
        for(int i = 1; i <= n / 2; i++)
        {
            for(int j = 1; Math.max(i, j) <= n - i - j; j++)
            {
                if(isValid(i, j, num))
                    return true;
            }
        }
        return false;
    }
    
    boolean isValid(int i, int j, String num)
    {
         /*Check for leading zero in both numbers. Note that both numbers are allowed to be zero, 
         * but it's not allowed to be more than one digit long with zero as the first digit.*/
        if(num.charAt(0) == '0' && i > 1)
            return false;
        if(num.charAt(i) == '0' && j > 1)
            return false;
        
        String sum = "";
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        
        /* Note that 'start' below is our "offset" for where the next sum comparison should occur in the given num.
         * Thus, start initializes to the lengths of the first and second numbers (due to zero-indexing,
         * start = 2 starts sum at the third digit of num).
         * Note also that offset increments by the length of the previous sum, which cleverly handles the sum's 
         * tendency to grow in length.*/
        for(int start = i + j; start < num.length(); start = start + sum.length())
        {
            // The second number becomes the sum of the first and second numbers
            x2 = x2 + x1;
            // The first number becomes the second number
            x1 = x2 - x1;
            
            sum = String.valueOf(x2);
            
            // Check whether the next digits of num, at an offset of offset, are sum
            if(!num.startsWith(sum, start))
                return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {	
    	AdditiveNumber obj = new AdditiveNumber();
    	System.out.println(obj.isAdditiveNumber("123"));
    	System.out.println(obj.isAdditiveNumber("112358"));
    	System.out.println(obj.isAdditiveNumber("199100199"));
	}
}
