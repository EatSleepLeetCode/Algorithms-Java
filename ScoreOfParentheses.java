
public class ScoreOfParentheses 
{
    public int scoreOfParentheses(String S) 
    {
        int result = 0;
        int layers = 0;
        
        for (int i = 0; i < S.length(); i++)
        {
            
            //Since input is balanced, we can safely do charAt(i + 1)
            //i.e. count of '(' and ') will be same
         
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')')
                result += 1 <<layers;
            if (S.charAt(i) == '(') layers++;
            else layers--;
        }
        return result;
    }
}
