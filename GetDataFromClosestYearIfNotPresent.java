import java.util.HashMap;
import java.util.Map;

public class GetDataFromClosestYearIfNotPresent 
{
	Map <Integer, Integer> yearMap; 
	Trie trie;
	
	public GetDataFromClosestYearIfNotPresent()
	{
		yearMap = new HashMap<Integer, Integer>();
		trie = new Trie();
	}
	
	void put(int year, int valObj)
	{
		yearMap.put(year, valObj);
		trie.insert(year, valObj);
	}
	
	int get(int year)
	{
		if (yearMap.containsKey(year))
		{
			return yearMap.get(year);
		}
		
		return yearMap.get(trie.search(year));
	}
	
	public static void main(String[] args) 
	{
		GetDataFromClosestYearIfNotPresent obj = new GetDataFromClosestYearIfNotPresent();
		obj.put(1990, 1);
		obj.put(1996, 9);
		obj.put(1992, 13);
		obj.put(1890, 5);
		obj.put(2000, 3);
		obj.put(2010, 2);
		obj.put(2003, 7);
		
		System.out.println(obj.get(1990));	//key exists in yearMap - return value of 1
		System.out.println(obj.get(1993));	//Closest year is 1992 (searched via backward scan) - return 13
		System.out.println(obj.get(1994));	//Closest year is 1996 (searched via forward scan) - return 9
		System.out.println(obj.get(1920));  //Closest year is 1890 (searched via backward scan) - return 5
		System.out.println(obj.get(2006));  //Closest year is 2003 (searched via backward scan) - return 7
		System.out.println(obj.get(2007));  //Closest year is 2003 (searched via forward scan) - return 2
		System.out.println(obj.get(2015));  //Closest year is 2003 (searched via forward scan) - return 2
		System.out.println(obj.get(3007));  //Closest year is 2010 (searched via backward scan) - return 2
		System.out.println(obj.get(1007));  //Closest year is 1890 (searched via forward scan) - return 5
	}
}

class TrieNode
{
	TrieNode[] links;
	int valObj;
	
	public TrieNode()
	{
		links = new TrieNode[10];
	}
	
	boolean containsKey(int key)
	{
		return links[key] != null;
	}
	
	TrieNode get(int key)
	{
		return links[key];
	}
	
	void put(int key, TrieNode node)
	{
		links[key] = node;
	}
}

class Trie
{
	TrieNode root;
	int prevYear;
	int nextYear;
	
	public Trie()
	{
		root = new TrieNode();
		prevYear = 0;
		nextYear = 0;
	}
	
	void insert(int year, int valObj)
	{
		TrieNode curr = root;
		
		for (int i = 0; i < 4; i++)		//input format is YYYY, so 4 iterations
		{
			int key = year / (int) Math.pow(10, 3 - i);
			year = year % (int) Math.pow(10, 3 - i);
			if (!curr.containsKey(key))
			{
				curr.put(key, new TrieNode());
			}
			curr = curr.get(key);
		}
		curr.valObj = valObj;
	}
	
	int search(int year)
	{
		TrieNode curr = root;
		
		if (!dfs(year, "", 0, curr, -1)) prevYear = 0;
		if (!dfs(year, "", 0, curr, 1)) nextYear = Integer.MAX_VALUE;
		
		return  ((year - prevYear) < (nextYear - year)) ? prevYear : nextYear;
	}
	
	boolean dfs(int year, String buildKey, int digit, TrieNode curr, int dir)
	{
		if (digit == 4)
		{
			if (dir > 0 && Integer.parseInt(buildKey) > year)
			{
				nextYear = Integer.parseInt(buildKey);
				return true;
			}
			if (dir < 0 && Integer.parseInt(buildKey) < year)
			{
				prevYear = Integer.parseInt(buildKey);
				return true;
			}
			return false;
		}
		
		for (int i = digit; i < 4; i++)
		{
			int key = dir < 0 ? 9 : 0;
			
			while (key >= 0 && key <= 9)
			{
				if (curr.containsKey(key))
				{
					buildKey += key;
					if (dfs(year, buildKey, digit + 1, curr.get(key), dir))
					{
						return true;
					}
					buildKey = buildKey.substring(0, buildKey.length() - 1);
				}

				key += dir;
			}
		}
		return false;
	}
}