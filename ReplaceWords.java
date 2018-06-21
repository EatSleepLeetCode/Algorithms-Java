import java.util.Arrays;
import java.util.List;

class ReplaceWords   
{
    public String replaceWords(List<String> dict, String sentence) 
    {
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        
        for (String dictWord : dict)
        {
            trie.insert(dictWord);
        }
        
        String[] arr = sentence.split(" ");
        for (String word : arr)
        {
            String wordRoot = trie.searchPrefix(word);
            
            sb.append(wordRoot.length() == 0 ? word : wordRoot).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) 
    {
    	ReplaceWords obj = new ReplaceWords();
    	System.out.println(obj.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}

class TrieNode
{
    TrieNode[] links;
    boolean isEnd;
    
    public TrieNode()
    {
        links = new TrieNode[26];
        isEnd = false;
    }
    
    boolean containsKey(char key)
    {
        return this.links[key - 'a'] != null;
    }
    
    TrieNode get(char key)
    {
        return this.links[key - 'a'];
    }
    
    void put(TrieNode node, char key)
    {
        this.links[key - 'a'] = node;
    }
    
    boolean isEnd(char key)
    {
        return this.isEnd;
    }
    
    void setEnd()
    {
        this.isEnd = true;
    }
}

class Trie
{
    TrieNode root;
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    void insert(String str)
    {
        TrieNode curr = root;
        char[] arr = str.toCharArray();
        
        for (char ch : arr)
        {
            if (!curr.containsKey(ch))
            {
                TrieNode newNode = new TrieNode();
                curr.put(newNode, ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    String searchPrefix(String str)
    {
        StringBuilder sb = new StringBuilder();
        
        TrieNode curr = root;
        char[] arr = str.toCharArray();
        
        for (char ch : arr)
        {
            if (!curr.containsKey(ch))
            {
                return "";
            }
            else
            {
                curr = curr.get(ch);
                sb.append(ch);
                
                if (curr.isEnd) 
                    return sb.toString();
            }
        }
        return "";
    }
}