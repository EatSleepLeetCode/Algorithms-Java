import java.util.HashMap;
import java.util.Map;

public class ShortEncodingOfWords 
{
    public int minimumLengthEncoding(String[] words) 
    {        
        TrieNode root = new TrieNode();
        Map<TrieNode, String> map = new HashMap<TrieNode, String>();
        int result = 0;
            
        for (String word : words)
        {
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; i--)
            {
                char key = word.charAt(i);
                if (!curr.containsKey(key))
                {
                    TrieNode node = new TrieNode();
                    curr.put(key, node);
                }                
                curr = curr.get(key);
            }
            map.put(curr, word);
        }
        
        for (TrieNode node : map.keySet())
        {
            if (node.count == 0)
            {
                result += map.get(node).length() + 1;   //+1 for #
            }
        }
        return result;
    }
}

class TrieNode
{
    TrieNode[] links;
    int count;
    
    public TrieNode()
    {
        links = new TrieNode[26];
        count = 0;
    }
    
    boolean containsKey(char key)
    {
        return links[key - 'a'] != null;
    }
    
    TrieNode get(char key)
    {
        return links[key - 'a'];
    }
    
    void put(char key, TrieNode node)
    {
        this.links[key - 'a'] = node;
        this.count++;
    }
}