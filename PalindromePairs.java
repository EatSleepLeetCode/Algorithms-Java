import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs 
{
	public List<List<Integer>> palindromePairs(String[] words) 
    {
        int n = words.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        if(n == 0)
            return result;
        
        for(int i = 0; i < n; i++)
        {
            map.put(words[i], i);
        }
        
        for(int i = 0; i < n; i++)
        {
            int currSize = words[i].length();
            
            for(int j = 0; j <= currSize; j++)          //Notice the <=
            {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if(isPalindrome(str1))
                {
                    String str2Rev = reverse(str2);
                    if(map.containsKey(str2Rev) && map.get(str2Rev) != i)
                    {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(map.get(str2Rev));
                        temp.add(i);
                        result.add(temp);
                    }
                }
                if(str2.length() > 0 && isPalindrome(str2))
                {
                    String str1Rev = reverse(str1);
                    if(map.containsKey(str1Rev) && map.get(str1Rev) != i)
                    {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        temp.add(map.get(str1Rev));
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
    
    boolean isPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;
        
        while(left < right)
        {
            if( str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
    
    String reverse(String str)
    {
        char[] strArr = str.toCharArray();
        
        int left = 0;
        int right = strArr.length - 1;
        
        while(left < right)
        {
            char ch = strArr[left];
            strArr[left] = strArr[right];
            strArr[right] = ch;
            
            left++;
            right--;
        }
        return new String(strArr);
    }
	public static void main(String[] args) 
	{
		PalindromePairs obj = new PalindromePairs();
		String[] words = new String[] {"bat", "tab", "cat"};				
		obj.palindromePairs(words);
		
		words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
		obj.palindromePairs(words);
	}

}
