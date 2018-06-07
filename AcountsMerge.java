import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AcountsMerge 
{
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
		DisjointSet ds = new DisjointSet();
		int n = accounts.size();
        
		for(int i = 0; i < n; i++)
		{
            List<String> emails = accounts.get(i);
                        
			for(int j = 1; j < emails.size(); j++)      //start from j = 1 becasue first element is customer name
			{
				ds.makeSet(emails.get(j));
				
				if(j > 1)
				{
					ds.union(emails.get(j - 1), emails.get(j));
				}
			}
		}
	
		Map<String, List<Integer>> emailMap = new HashMap<String, List<Integer>>();
		for(int i = 0; i < n; i++)
		{
			List<String> emails = accounts.get(i);
            
            String email = emails.get(1);           //check email at 1st index becasue 0th element is customer name
            String emailParent = ds.findSet(email);

            if(!emailMap.containsKey(emailParent))
            {
                emailMap.put(emailParent, new ArrayList<Integer>());
            }
            emailMap.get(emailParent).add(i);
		}

        List<List<String>> result = new ArrayList<List<String>>();
        for(List<Integer> customers : emailMap.values())
        {            
            Set<String> sameCustomerEmailsSet = new TreeSet<String>();  //TreeSet because emails need to sorted
            String customerName = accounts.get(customers.get(0)).get(0);            
                        
            for(int i = 0; i < customers.size(); i++)
            {
                for(int j = 1; j < accounts.get(customers.get(i)).size(); j++)
                sameCustomerEmailsSet.add(accounts.get(customers.get(i)).get(j));
            }
            
            List<String> sameCustomerEmailsList = new ArrayList<String>(sameCustomerEmailsSet);
            sameCustomerEmailsList.add(0, customerName);
            result.add(sameCustomerEmailsList);
        }
		return result;
	}
    
	public static void main(String[] args) 
	{			
		AcountsMerge obj = new AcountsMerge();
		List<List<String>> accounts = new ArrayList<List<String>>();
		
		List<String> temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("2");
		temp.add("3");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("4");
		temp.add("5");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("0");
		temp.add("1");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("3");
		temp.add("4");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("7");
		temp.add("8");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("1");
		temp.add("2");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("6");
		temp.add("7");
		accounts.add(temp);
		
		temp = new ArrayList<String>();		
		temp.add("c");
		temp.add("5");
		temp.add("6");
		accounts.add(temp);
		
		System.out.println(obj.accountsMerge(accounts));
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
		while(node != node.parent)
		{
			node.parent = node.parent.parent;
			node = node.parent;
		}		
		return node;
	}
}