public class ValidParenthesisString
{
    public boolean checkValidString(String s) 
    {
        int n = s.length();
        int sum = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') sum++;
            else sum--;
            
            if (sum < 0) return false;
        }
        
        if (sum == 0) return true;        
        sum = 0;
        
        for (int i = n - 1; i >= 0; i--)
        {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') sum++;
            else sum--;
            
            if (sum < 0) return false;
        }        
        return true;
    }
    public static void main(String[] args)
    {
        ValidParenthesisString obj = new ValidParenthesisString();
        System.out.println(obj.checkValidString("()"));
        System.out.println(obj.checkValidString("(*)"));
        System.out.println(obj.checkValidString("(*))"));
        System.out.println(obj.checkValidString("(*))"));
        System.out.println(obj.checkValidString("())"));
    }
}
