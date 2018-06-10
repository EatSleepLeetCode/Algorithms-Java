import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates 
{
    public List<String> ambiguousCoordinates(String S) 
    {
        List<String> result = new ArrayList<String>();
        int n = S.length();
        
        for (int i = 2; i < n - 1; i++)          //loop for comma - 2 to n - 2
        {
            for (String left : makeString(S, 1, i))             //first co-ordinate
            {
                for (String right : makeString(S, i, n - 1))    //second co-ordinate
                {
                    result.add("(" + left + ", " + right + ")");
                }
            }
        }
        return result;
    }
    
    List<String> makeString(String S, int i, int j)
    {
        List<String> curr = new ArrayList<String>();
        
        for (int d = 1; d <= j - i; d++)                        //loop for decimals
        {
            String left = S.substring(i, i + d);
            String right = S.substring(i + d, j);
            
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0"))
            {
                curr.add(left + (d < j - i ? "." : "") + right);
            }
        }
        return curr;
    }
    
	public static void main(String[] args) 
	{
		AmbiguousCoordinates obj = new AmbiguousCoordinates();
		System.out.println(obj.ambiguousCoordinates("(123)"));
	}

}
