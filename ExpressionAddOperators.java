import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators 
{
	 public List<String> addOperators(String num, int target) 
	    {
	        List<String> result = new ArrayList<String>();
	        
	        if(num.length() == 0)
	            return result;
	        
	        helper(result, num, target, "", 0, 0, 0);
	        return result;
	    }
	    
	    void helper(List<String> result, String input, int target, String subResult, int start, long currEval, long currMult)
	    {
	        if(start == input.length())
	        {
	            if(currEval == target)
	            {
	                result.add(subResult);
	            }
	            return;
	        }
	        
	        for(int i = start; i < input.length(); i++)
	        {
	            if(i != start && input.charAt(start) == '0')
	                break;
	            
	            long currDigit = Long.parseLong(input.substring(start, i + 1));
	            
	            if(start == 0)
	            {
	                helper(result, input, target, currDigit + "", i + 1, currDigit, currDigit);
	            }
	            else
	            {
	                helper(result, input, target, subResult + "+" + currDigit, i + 1, currEval + currDigit, currDigit);

	                helper(result, input, target, subResult + "-" + currDigit, i + 1, currEval - currDigit, -currDigit);

	                helper(result, input, target, subResult + "*" + currDigit, i + 1, currEval - currMult + currMult * currDigit, currMult * currDigit);
	            }
	        }
	        
	    }
	
	public static void main(String[] args) 
	{
		ExpressionAddOperators obj = new ExpressionAddOperators();
		obj.addOperators("232", 8);
	}

}
