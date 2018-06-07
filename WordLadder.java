import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder 
{
    //Solution 1
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> wordListSet = new HashSet<String>(wordList);
        
        if(!wordListSet.contains(endWord))
            return 0;
        
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int distance = 1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty())
        {
           // Not necessary
            if(beginSet.size() > endSet.size())
            {
                Set<String> backUp = beginSet;
                beginSet = endSet;
                endSet = backUp;
            }
            
            Set<String> toAdd = new HashSet<>();
            
            for(String word : beginSet)
            {                
                for(int i = 0; i < word.length(); i++)
                {
                    //Make sure to perform this step inside loop that goes over all characters 
                    //of the word. Otherwise after first iteration we will be starting with z**
                    char[] wordCharArray = word.toCharArray();  
                    
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        wordCharArray[i] = ch;
                        
                        String updatedWord = new String(wordCharArray);
                        
                        if(endSet.contains(updatedWord))
                        {
                            return distance+1;
                        }
                        
                        if(!visited.contains(updatedWord) && wordListSet.contains(updatedWord))
                        {
                            toAdd.add(updatedWord);
                            visited.add(updatedWord);
                        }
                    }
                }
            }            
            distance++;            
            beginSet = toAdd;
        }
        return 0;
    }
    
    //Solution 2 - Using Queue - This one is slower as compare to other solution
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> wordListSet = new HashSet<String>(wordList);
        if(!wordListSet.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.offer(beginWord);

        int distance = 0;
        
        while(!q.isEmpty())
        {
        	distance++;
        	int size = q.size();
        	for(int qElem = 0; qElem < size; qElem++)
        	{
                String word = q.poll();
                
                for(int i = 0; i < word.length(); i++)
                {
                    //Make sure to perform this step inside loop that goes over all characters 
                    //of the word. Otherwise after first iteration we will be starting with z**
                    char[] wordCharArray = word.toCharArray();  

                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        wordCharArray[i] = ch;
                        String updatedWord = new String(wordCharArray);

                        if(endWord.equals(updatedWord))
                        {
                            return distance+1;
                        }

                        if(!visited.contains(updatedWord) && wordListSet.contains(updatedWord))
                        {
                            q.offer(updatedWord);
                            visited.add(updatedWord);
                        }
                    }
                }	
        	}        	
        }
        return 0;
    }

	public static void main(String[] args) 
	{
		WordLadder obj = new WordLadder();
		List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		System.out.println(obj.ladderLength2("hit", "cog", wordList));
	}
}
