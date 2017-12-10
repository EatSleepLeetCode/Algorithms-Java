
public class WordDictionary 
{
	public static void main(String[] args)
	{
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
	}
	
	
    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() 
    {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) 
    {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) 
    {
        return trie.search(word);
    }
}

class TrieNode
{
    TrieNode[] links;
    boolean isEnd;
    
    public TrieNode()
    {
        links = new TrieNode[26];
    }
    
    boolean containsKey(char key)
    {
        return (links[key - 'a'] != null);
    }
    
    TrieNode get(char key)
    {
        return links[key - 'a'];
    }
    
    void put(char key, TrieNode node)
    {
        links[key-'a'] = node;
    }
    
    void setEnd()
    {
        isEnd = true;
    }
    
    boolean isEnd()
    {
        return isEnd;
    }
}


class Trie 
{
    TrieNode root;   

    /** Initialize your data structure here. */
    public Trie() 
    {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode node = root;
        
        for(int i = 0; i< word.length(); i++)
        {
            char key = word.charAt(i);
            
            if(!node.containsKey(key))
            {
                TrieNode newNode = new TrieNode();
                node.put(key, newNode);
            }
            node = node.get(key); //keep iterating over nodes to put all characters of a word
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        return searchPrefix(word, 0, root);
    }
    
    public boolean searchPrefix(String word, int index, TrieNode node)
    {
        if(index == word.length())
        {
            return node.isEnd();
        }
        
        char key = word.charAt(index);
                
        if(key == '.')
        {
            for(char ch = 'a'; ch <= 'z'; ch++)
            {
            	if(node.containsKey(ch))
            	{
                    TrieNode curr = node.get(ch);
                    if(searchPrefix(word, index + 1, curr))
                    {
                        return true;
                    }
            	}
            }
        }
        else
        {
            if(node.containsKey(key))
            {
                node = node.get(key);
                return searchPrefix(word, index + 1, node);
            }
            else
            {
                return false;
            }
        }
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {    
        return searchPrefix(prefix, 0, root);
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */