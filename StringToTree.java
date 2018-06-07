import java.util.Stack;

class StringToTree 
{
	TreeNode str2Tree(String S)
	{
		if(S.length() == 0)
			return null;
		
		int firstParentheses = S.indexOf("("); 
		
		int val = firstParentheses == - 1 ? Integer.parseInt(S) : Integer.parseInt(S.substring(0, firstParentheses));
		TreeNode curr = new TreeNode(val);
		
		if(firstParentheses == -1)
			return curr;
		
		int start = firstParentheses;
		int leftParenthesesCount = 0;
		
		for(int i = start; i < S.length(); i++)
		{
			if(S.charAt(i) == '(')
				leftParenthesesCount++;
			else if(S.charAt(i) == ')')
				leftParenthesesCount--;
			
			if(leftParenthesesCount == 0 && start == firstParentheses)
			{
				curr.left = str2Tree(S.substring(start + 1, i));
				start = start + i;
			}
			else if(leftParenthesesCount == 0)
			{
				curr.right = str2Tree(S.substring(start + 1, i));
			}
		}
		return curr;
	}
	
    public static void main(String[] args)
    {
        StringToTree obj = new StringToTree();
        obj.str2Tree("4(2(3)(1))(6(5))");
    }    
}

