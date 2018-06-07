import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses 
{
    public List<String> removeInvalidParentheses(String s) 
    {
        List<String> result = new ArrayList<String>();
        remove(result, s, 0, 0, new char[]{'(', ')'});
        return result;
    }
    
    void remove(List<String> result, String s, int lastI, int lastJ, char[] par)
    {
        int counter = 0;
        for(int i = lastI; i < s.length(); i++)
        {
            if(s.charAt(i) == par[0])
                counter++;
            else if(s.charAt(i) == par[1])
                counter--;
            
            if(counter >= 0)
                continue;
            
            for(int j = lastJ; j <= i; j++)
            {
                if(s.charAt(j) == par[1] && (j == lastJ ||s.charAt(j - 1) != par[1]))
                {
                    remove(result, s.substring(0, j) + s.substring(j + 1), i, j, par);
                }
            }
            return;                                                 //Important
        }
        
        String sReverse = new StringBuilder(s).reverse().toString();
        if(par[0] == '(')                                           // finished left to right
            remove(result, sReverse, 0, 0, new char[]{')', '('});
        else                                                        // finished right to left
            result.add(sReverse);
    }
	
	public static void main(String[] args)
	{
		RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
		obj.removeInvalidParentheses("())");	
	}
}
