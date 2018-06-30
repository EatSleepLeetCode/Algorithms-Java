import java.util.List;
import java.util.ArrayList;

public class RemoveComments
{
    public List<String> removeComments(String[] source) 
    {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean multiLineMode = false;
        
        for (String str : source)
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (multiLineMode)
                {
                    if (str.charAt(i) == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/')
                    {
                        multiLineMode = false;
                        i++;
                    }
                }
                else
                {
                    if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '/')
                    {
                        break;
                    }
                    else if (str.charAt(i) == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*')
                    {
                        multiLineMode = true;
                        i++;
                    }
                    else
                    {
                        sb.append(str.charAt(i));
                    }
                }
            }
            
            if (!multiLineMode && sb.length() > 0)
            {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        RemoveComments obj = new RemoveComments();
        System.out.println(obj.removeComments(new String[] {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
    }
}
