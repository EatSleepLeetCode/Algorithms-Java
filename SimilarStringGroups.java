import java.util.HashMap;
import java.util.Map;

public class SimilarStringGroups 
{
    public int numSimilarGroups(String[] A) 
    {
        int n = A.length;
        DisjointSet ds = new DisjointSet();        
        
        for (String str : A)
            ds.makeSet(str);

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (isSimilar(A[i], A[j]))
                {
                    ds.union(A[i], A[j]);
                }
            }
        }
        return ds.size;
    }                    
    
    boolean isSimilar(String str1, String str2)
    {
        int n = str1.length();
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n)
        {
            if (str1.charAt(i) != str2.charAt(j))
            {
                count++;
            }

            i++;
            j++;
        }
        
        //Since all words are anagrams, we can 
        //assume words in a group will differ by 2
        
        return count == 2;      
    }
    
	public static void main(String[] args) 
	{
		SimilarStringGroups obj = new SimilarStringGroups();
		System.out.println(obj.numSimilarGroups(new String[] {"ovm","ovm", "ovm"}));
		System.out.println(obj.numSimilarGroups(new String[] {"ovm","omv"}));
		System.out.println(obj.numSimilarGroups(new String[] {"tars","rats","arts","star"}));		
	}

}

class Node
{
    String val;
    Node parent;
    int rank;
}

class DisjointSet
{
    int size;
    Map<String, Node> map = new HashMap<String, Node>();
    
    void makeSet(String val)
    {
        if (map.containsKey(val))       //Don't do anything, if word is already seen
    		return;
        
        Node node = new Node();
        node.val = val;
        node.parent = node;
        node.rank = 0;
                
        map.put(val, node);
        size++;                         //Only increase size when a new word is seen
     }
    
    void union(String str1, String str2)
    {
        Node node1 = map.get(str1);
        Node node2 = map.get(str2);
        
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        
        if (parent1 == parent2)
            return;
        
        size--;
        
        if (parent1.rank >= parent2.rank)
        {
            parent2.parent = parent1;
            
            if (parent1.rank == parent2.rank)
            {
                parent1.rank++;
            }
        }
        else
        {
            parent1.parent = parent2;
        }
    }
    
    String findSet(String str)
    {
        Node node = map.get(str);
        return findSet(node).val;
    }
    
    Node findSet(Node node)
    {
        while (node.parent != node)
        {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }
}