
public class MultiplyStrings 
{
   public String multiply(String num1, String num2) 
    {
        int n1 = num1.length();
        int n2 = num2.length();
        
        int[] products = new int[n1 + n2];
        int sum = 0;
        int carry = 0;
        int product = 0;
        
        for(int i = n1 - 1; i >= 0; i--)
        {
            for(int j = n2 - 1; j >= 0; j--)
            {
                product = (int)((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                
                products[i + j + 1] = products[i + j + 1] + product;
            }
        }
     
        for(int i = n1 + n2 - 1; i >= 0; i--)
        {
            sum = products[i] + carry;
            carry = sum / 10;
            products[i] = sum % 10;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int val : products)
        {
            sb.append(val);
        }
        
        while(sb.length() != 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        
        if(sb.length() == 0)
            return "0";
        else
            return sb.toString();
    }
   
   
   public static void main(String[] args)
   {
	   MultiplyStrings obj = new MultiplyStrings();
	   System.out.println(obj.multiply("25", "82"));
   }
}