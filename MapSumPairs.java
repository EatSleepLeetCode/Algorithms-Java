public class MapSumPairs 
{
    Trie trie;
    
    public MapSumPairs() 
    {
        trie = new Trie();
    }
    
    public void insert(String key, int val) 
    {
        trie.insert(key, val);
    }
    
    public int sum(String prefix) 
    {
        return trie.getSum(prefix);
    }
    
    public static void main(String[] args)
    {
        MapSumPairs obj = new MapSumPairs();
        obj.insert("apple", 3);
        System.out.println(obj.sum("apple"));
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 10);
        System.out.println(obj.sum("ap"));
    }
}

class TrieNode
{
    TrieNode[] links;
    int[] scores;
    boolean isEnd;
    
    public TrieNode()
    {
        links = new TrieNode[26];
        scores = new int[26];
    }
    
    void updateScore(char key, int val)
    {
        scores[key - 'a'] += val;
    }
    
    int getScore(char key)
    {
        return scores[key - 'a'];
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
        links[key - 'a'] = node;
    }
    
    boolean isEnd()
    {
        return isEnd;
    }
    
    void setIsEnd()
    {
        isEnd = true;
    }
}

class Trie
{
    TrieNode root = new TrieNode();
    
    void insert(String word, int val)
    {                
        if (search(word))
            val = val - getSum(word);
                
        TrieNode curr = root;
        for (char key : word.toCharArray())
        {
            if (!curr.containsKey(key))
            {
                TrieNode newNode = new TrieNode();
                curr.put(key, newNode);
            }
            
            curr.updateScore(key, val);
            curr = curr.get(key);
        }
        curr.setIsEnd();
    }
    
    boolean search(String prefix)
    {
        TrieNode curr = root;
        
        for (char key : prefix.toCharArray())
        {
            if (curr.containsKey(key))
            {
                curr = curr.get(key);
            }
            else
            {
                return false;
            }
        }
        return curr.isEnd();
    }
    
    int getSum(String prefix)
    {
        TrieNode curr = root;
        int score = 0;
        
        for (char key : prefix.toCharArray())
        {
            if (curr.containsKey(key))
            {
                score = curr.getScore(key);
                curr = curr.get(key);
            }
            else
            {
                score = 0;
                break;
            }
        }
        return score;
    }
}
