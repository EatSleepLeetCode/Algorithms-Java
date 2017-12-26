
public class AdditiveNumber 
{
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
        if(num.charAt(0) == '0' && i > 1)
            return false;
        
        if(num.charAt(i) == '0' && j > 1)
            return false;
        
        String sum = "";
        
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        
        for(int start = i + j; start < num.length(); start = start + sum.length())
        {
            x2 = x2 + x1;
            x1 = x2 - x1;
            
            sum = String.valueOf(x2);
            
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
