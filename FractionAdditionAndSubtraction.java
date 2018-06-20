import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction 
{
    public String fractionAddition(String exp) 
    {
        List<String> nums = new ArrayList<String>();        
        int i = 0, j = 0;
        
        while (j <= exp.length())
        {
            if (j == exp.length() || j != i && (exp.charAt(j) == '+' || exp.charAt(j) == '-'))
            {
                if (exp.charAt(i) == '+')
                    nums.add(exp.substring(i + 1, j));
                else
                    nums.add(exp.substring(i, j));
                
                i = j;
            }
            j++;
        }
        
        String result = "0/1";
        
        for (String num : nums)
            result= add(result, num);
        
        return result;
    }
    
    String add(String s1, String s2)
    {
        String[] sa1 = s1.split("/");
        String[] sa2 = s2.split("/");
        
        int n1 = Integer.parseInt(sa1[0]);
        int d1 = Integer.parseInt(sa1[1]);
        int n2 = Integer.parseInt(sa2[0]);
        int d2 = Integer.parseInt(sa2[1]);
        
        int n = n1 * d2 + n2 * d1;
        int d = d1 * d2;
        
        if (n == 0) return "0/1";
        
        boolean isNegative = n * d < 0;
        
        n = Math.abs(n);
        d = Math.abs(d);
        
        int gcd = getGCD(n, d);
        
        return (isNegative ? "-" : "") + (n / gcd) + "/" + (d / gcd);        
    }
    
    int getGCD(int num1, int num2)
    {
        while (num2 != 0)
        {
            int backUp = num2;            
            num2 = num1 % num2;
            num1 = backUp;
        }
        return num1;
    }
}
