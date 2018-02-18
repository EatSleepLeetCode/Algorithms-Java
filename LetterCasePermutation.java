import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation 
{	
    public List<String> letterCasePermutation(String S) 
    {
        List<String> result = new ArrayList<>();
        helper(result, S.toCharArray(), 0);
        return result;
    }
    
    public void helper(List<String> result, char[] arr, int index)
    {
        if(index == arr.length)
        {
            result.add(new String(arr));
        }
        else
        {
            if(Character.isLetter(arr[index]))
            {
                arr[index] = Character.toLowerCase(arr[index]);
                helper(result, arr, index + 1);
                arr[index] = Character.toUpperCase(arr[index]);
            }
            helper(result, arr, index + 1);
        }
    }
    
	public static void main(String[] args) 
	{
		LetterCasePermutation obj = new LetterCasePermutation();
		System.out.println(obj.letterCasePermutation("a1b2"));
	}
}
