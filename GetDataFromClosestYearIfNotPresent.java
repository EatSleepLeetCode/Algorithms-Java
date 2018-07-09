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
		trie.insert(year);
	}
	
	int get(int year)
	{
		if (yearMap.containsKey(year)) return yearMap.get(year);
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
		obj.put(2090, 17);
		
		System.out.println(System.currentTimeMillis());
		System.out.println(obj.get(1990));	//key exists in yearMap - return value of 1
		System.out.println(obj.get(1993));	//Closest year is 1992 (searched via backward scan) - return 13
		System.out.println(obj.get(1994));	//Closest year is 1996 (searched via forward scan) - return 9
		System.out.println(obj.get(1920));  //Closest year is 1890 (searched via backward scan) - return 5
		System.out.println(obj.get(2006));  //Closest year is 2003 (searched via backward scan) - return 7
		System.out.println(obj.get(2007));  //Closest year is 2003 (searched via forward scan) - return 2
		System.out.println(obj.get(2015));  //Closest year is 2003 (searched via forward scan) - return 2
		System.out.println(obj.get(3007));  //Closest year is 2090 (searched via forward scan) - return 17
		System.out.println(obj.get(1007));  //Closest year is 1890 (searched via forward scan) - return 5
		System.out.println(System.currentTimeMillis());
	}
}

class TrieNode
{
	TrieNode[] links;
	
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
	final int SIZE = 5;
	TrieNode root;
	int prevYear;
	int nextYear;
	
	public Trie()
	{
		root = new TrieNode();
		prevYear = Integer.MIN_VALUE;
		nextYear = Integer.MAX_VALUE;
	}
	
	void insert(int year)
	{
		TrieNode curr = root;
		
		for (int i = 0; i < SIZE; i++)		//input format is YYYY, so SIZE i.e. 4 iterations
		{
			int key = year / (int) Math.pow(10, SIZE - 1 - i);
			year = year % (int) Math.pow(10, SIZE - 1 - i);
			if (!curr.containsKey(key))
			{
				curr.put(key, new TrieNode());
			}
			curr = curr.get(key);
		}
	}
	
	int search(int year)
	{
		prevYear = 0;
		nextYear = Integer.MAX_VALUE;

		TrieNode curr = root;
		dfs(year, "", 0, curr, -1, true);
		dfs(year, "", 0, curr, 1, true);	//no need to reset curr because we don't update curr in DFS
		return  ((year - prevYear) < (nextYear - year)) ? prevYear : nextYear;
	}
	
	boolean dfs(int year, String buildKey, int index, TrieNode curr, int dir, boolean prevDigitIsSame)
	{
		if (index == SIZE) 
		{
			if (dir < 0) prevYear = Integer.parseInt(buildKey);
			if (dir > 0) nextYear = Integer.parseInt(buildKey);
			return true;
		}
		
		int yearDigit = 0;
		
		if (prevDigitIsSame)
			yearDigit = (year / (int) Math.pow(10, SIZE - 1 - index)) % 10;
		else
			yearDigit = dir < 0 ? 9 : 0;
		
		int key = yearDigit;
		
		do
		{
			if (dir < 0 && Integer.parseInt(buildKey + key) > (year / (int) Math.pow(10, SIZE - 1 - index))) return false;
			if (dir > 0 && Integer.parseInt(buildKey + key) < (year / (int) Math.pow(10, SIZE - 1 - index))) return false;
				
			if (curr.containsKey(key))
			{
				buildKey += key;
				if (dfs(year, buildKey, index + 1, curr.get(key), dir, key == yearDigit))
				{
					return true;
				}
				buildKey = buildKey.substring(0, buildKey.length() - 1);
			}
			key = (key + dir + 10) % 10;
		}
		while(key != yearDigit);

		return false;
	}
}
