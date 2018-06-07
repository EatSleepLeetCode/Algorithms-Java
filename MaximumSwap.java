
public class MaximumSwap 
{
    public int maximumSwap(int num) 
    {
        char[] digits = String.valueOf(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) 
        {
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) 
        {
            for (int k = 9; k > digits[i] - '0'; k--) 
            {
                if (buckets[k] > i) 
                {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];     //or (char)(k + '0')
                    digits[buckets[k]] = tmp;
                
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;    
    }
    
	public static void main(String[] args) 
	{
		MaximumSwap obj = new MaximumSwap();
		System.out.println(obj.maximumSwap(2736));
	}
}
