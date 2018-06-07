
public class PrefixAndSuffixSearch 
{
    TrieNode trie;

    public PrefixAndSuffixSearch(String[] words) 
    {
        trie = new TrieNode();
        
        for (int weight = 0; weight < words.length; weight++) 
        {
            String word = words[weight] + "{";
            
            for (int i = 0; i < word.length(); i++) 
            {
                TrieNode cur = trie;
                cur.weight = weight;
                
                //Trie word insertion is done as suffix + "{" + prefix
                for (int j = i; j < 2 * word.length() - 1; j++) 
                {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.links[k] == null)
                        cur.links[k] = new TrieNode();
                    cur = cur.links[k];
                    cur.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) 
    {
        TrieNode cur = trie;
        for (char letter: (suffix + "{" + prefix).toCharArray()) 
        {
            if (cur.links[letter - 'a'] == null)
                return -1;
            
            cur = cur.links[letter - 'a'];
        }
        return cur.weight;
    }

    //Using 27 size because we need to account for "{" i.e. ASCII value 123
    //The reason we are using "{" as delimiter because its ASCII value is next to z 
	class TrieNode 
	{
	    TrieNode[] links;
	    int weight;
	    public TrieNode() 
	    {
	        links = new TrieNode[27];
	        weight = 0;
	    }
	}
	
	public static void main(String[] args) 
	{
		PrefixAndSuffixSearch obj = new PrefixAndSuffixSearch(new String[] {"apple"});
		obj.f("a", "e");
	}
}
