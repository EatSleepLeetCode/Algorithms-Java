import java.util.Stack;

public class LongestAbsoluteFilePath 
{
    public int lengthLongestPath(String input) 
    {
        String[] tokens = input.split("\n");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) 
        {
            int level = countLevel(s);

            // if current directory/file depth is lower that the top directory/file on the stack, pop from stack 
            while (stack.size() > level) 
            {
                curLen -= stack.pop();
            }

            // +1 here because a "/" needs to be counted following each directory
            int len = s.replaceAll("\t", "").length() + 1;
            
            curLen += len;

            // if s contains ".", we have found a file!
            if (s.contains(".")) {
                result = Math.max(result, curLen - 1);
            }
            stack.add(len);
        }
        return result;
    }
    
    private int countLevel(String s) 
    {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }

	public static void main(String[] args) 
	{
		LongestAbsoluteFilePath obj = new LongestAbsoluteFilePath();
		System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}
}
