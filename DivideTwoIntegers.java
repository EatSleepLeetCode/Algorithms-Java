
public class DivideTwoIntegers 
{
    public int divide(int dividend, int divisor) 
    {

        long lresult = 0;
        
        if(divisor == 0)
            return Integer.MAX_VALUE;
                
        //bcoz -1 * Integer.MIN_VALUE becomes Integer.MAX_VALUE + 1
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        int sign = 1;
        
        if((dividend < 0 && divisor > 0)  || (dividend > 0 && divisor < 0))
            sign = -1;
        
        //Use long becoz if dividend is Integer.MAX_VALUE then lcurrDivisor (in int format)
        //will overflow and become -ve and we run in to infinite loop
        
        //first typecast to long because if dividend is then -1 * Integer.MIN_VALUE
        //becomes Integer.MAX_VALUE + 1
        long ldividend = Math.abs((long)dividend);  
        long ldivisor = Math.abs((long)divisor);
        
        while(ldividend >= ldivisor)
        {
            long lcurrDivisor = ldivisor;
            int multiple = 1;
            
            while(ldividend >= (lcurrDivisor << 1))
            {
                lcurrDivisor = lcurrDivisor << 1;
                multiple = multiple << 1;                
            }           
            
            ldividend -= lcurrDivisor;
            lresult += multiple;
        }
        
        return (int)(sign * lresult);
    }

    public static void main(String[] args) 
    {
    	DivideTwoIntegers obj = new DivideTwoIntegers();
    	obj.divide(11, 3);
	}

}
