import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerEmails 
{
	List<List<String>> uniqueSets(Map<String, List<String>> input)
	{	
		DisjointSet ds = new DisjointSet();
		
		for(List<String> emails : input.values())
		{
			for(int j = 0; j < emails.size(); j++)
			{
				ds.makeSet(emails.get(j));
				
				if(j > 0)
				{
					ds.union(emails.get(j - 1), emails.get(j));
				}
			}
		}
	
		Map<String, List<String>> emailMap = new HashMap<String, List<String>>();
		for(Map.Entry<String, List<String>> entry : input.entrySet())
		{
			List<String> emails = entry.getValue();
			String email = emails.get(0);
			String emailParent = ds.findSet(email);
			
			if(!emailMap.containsKey(emailParent))
			{
				emailMap.put(emailParent, new ArrayList<String>());
			}
			emailMap.get(emailParent).add(entry.getKey());
		}
		
		List<List<String>> result = new ArrayList<List<String>>();
		for(List<String> emails : emailMap.values())
			result.add(emails);
		
		return result;
	}
		
	public static void main(String[] args) 
	{
		/*
			c1 = <e1, e2>
			c2 = <e2>
			c3 = <e3, e4>
		*/
		
		CustomerEmails obj = new CustomerEmails();
		Map<String, List<String>> custEmailMap = new HashMap<String, List<String>>();
		custEmailMap.put("c1", new ArrayList<>());
		custEmailMap.get("c1").add("e1");
		custEmailMap.get("c1").add("e2");
		
		custEmailMap.put("c2", new ArrayList<>());
		custEmailMap.get("c2").add("e2");

		custEmailMap.put("c3", new ArrayList<>());
		custEmailMap.get("c3").add("e3");
		custEmailMap.get("c3").add("e2");

		custEmailMap.put("c4", new ArrayList<>());
		custEmailMap.get("c4").add("e5");
		custEmailMap.get("c4").add("e4");

		custEmailMap.put("c5", new ArrayList<>());
		custEmailMap.get("c5").add("e6");
		custEmailMap.get("c5").add("e2");

		System.out.println(obj.uniqueSets(custEmailMap));
	}
}

class Node
{
	String data;
	Node parent;
	int rank;
}

class DisjointSet
{
	Map<String, Node> nodeMap = new HashMap<String, Node>();
	
	void makeSet(String val)
	{
		if(!nodeMap.containsKey(val))
		{
			Node node = new Node();
			node.data = val;
			node.parent = node;
			node.rank = 0;
			
			nodeMap.put(val, node);
		}
	}
	
	void union(String val1, String val2)
	{
		Node node1 = nodeMap.get(val1);
		Node node2 = nodeMap.get(val2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		if(parent1 == parent2)
			return;
		
		if(parent1.rank >= parent2.rank)
		{
			parent2.parent = parent1;
			
			if(parent1.rank == parent2.rank)
				parent1.rank++;				
		}
		else
		{
			parent2.parent = parent1;
		}
	}
	
	String findSet(String val)
	{
		Node node = nodeMap.get(val);
		Node parent = findSet(node);
		return parent.data;
	}
	
	Node findSet(Node node)
	{
		if(node!= node.parent)
		{
			node.parent = node.parent.parent;
			node = node.parent;
		}		
		return node;
	}
}
