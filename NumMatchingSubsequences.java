import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumMatchingSubsequences 
{
    public int numMatchingSubseq(String S, String[] words) 
    {
        Map<Character, Queue<String>> wordsMap = new HashMap<Character, Queue<String>>();
        
        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            wordsMap.putIfAbsent(ch, new LinkedList<String>());
        }
        
        for(String word : words)
        {
            wordsMap.get(word.charAt(0)).offer(word);
        }
        
        int count = 0;
        for(int i = 0; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            Queue<String> q = wordsMap.get(ch);
            int size = q.size();
            
            for(int j = 0; j < size; j++)
            {
                String word = q.poll();
                
                if(word.length() == 1)
                {
                    count++;
                }
                else
                {
                    wordsMap.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) 
    {
    	NumMatchingSubsequences obj = new NumMatchingSubsequences();
    	System.out.println(obj.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
	}
}
