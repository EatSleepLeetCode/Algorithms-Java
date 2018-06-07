import java.util.Stack;

public class DecodeString 
{
    public String decodeString(String s) 
    {
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resultStack = new Stack<String>();
        String result = "";
        
        int n = s.length();
        int index = 0;
        int count = 0;
        
        while(index < n)
        {
            char ch = s.charAt(index);
            
            if(isDigit(ch))
            {
                count = 0;
                while(isDigit(ch))
                {
                    count = count * 10 + ch - '0';
                    index++;
                    ch = s.charAt(index);
                }
                countStack.push(count);
            }
            else if(ch == '[')
            {
                resultStack.push(result);
                result ="";
                index++;
            }
            else if(ch == ']')
            {
                StringBuilder curr = new StringBuilder();
                curr.append(resultStack.pop());
                
                count = countStack.pop();
                for(int i = 0; i < count; i++)
                {
                    curr.append(result);
                }
                result = curr.toString();
                index++;
            }
            else
            {
                result += ch;
                index++;
            }
        }
        return result;
    }
    
    boolean isDigit(char ch)
    {
        return ch >= 48 && ch <= 57;
    }
	public static void main(String[] args) 
	{
		DecodeString obj = new DecodeString();
		obj.decodeString("3[ab2[c]]");
	}
}
