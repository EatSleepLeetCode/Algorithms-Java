
public class MaskingPersonalInfo 
{
    public String maskPII(String S) 
    {
        int indexAmpersand = S.indexOf('@');
        
        //If it's email
        if (indexAmpersand >= 0)
            return (S.charAt(0) + "*****" + S.substring(indexAmpersand - 1)).toLowerCase();
                
        //If it's phone
        String digits = S.replaceAll("\\D", "");              
        String local = "***-***-" + digits.substring(digits.length() - 4);
        
        if (digits.length() == 10)
            return local;
        
        String result = "+";
        for (int i = 0; i < digits.length() - 10; i++)
            result += "*";
                            
        return result + "-" + local;
    }
}
