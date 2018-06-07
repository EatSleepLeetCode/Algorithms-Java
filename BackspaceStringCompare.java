import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class BackspaceStringCompare 
{	
    public boolean backspaceCompare(String S, String T) 
    {
        return parseString(S).equals(parseString(T));
    }
    
    String parseString(String str)
    {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : str.toCharArray())
        {
            if (ch == '#')
            {
            	if (sb.length() > 0)
                {
            		sb.deleteCharAt(sb.length() - 1);
                }
            }
            else
            {
            	sb.append(ch);
            }
        }
        return sb.toString();
    }

	public static void main(String[] args) 
	{
		BackspaceStringCompare obj = new BackspaceStringCompare();	
		System.out.println(obj.backspaceCompare("y#fo##f", "y#f#o#f"));
	}	
}