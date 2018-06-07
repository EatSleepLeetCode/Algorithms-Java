import java.util.HashMap;
import java.util.Map;

public class DisjointSet 
{
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	int size;

	public DisjointSet()
	{
		size = 0;
	}
		
	void makseSet(int val)
	{
		if(map.containsKey(val))
			return;
		
		Node node = new Node();
		node.val = val;
		node.rank = 0;
		node.parent = node;
		
		map.put(val, node);
		size++;
	}
	
	void union(int val1, int val2)
	{
		Node node1 = map.get(val1);
		Node node2 = map.get(val2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		if(parent1 == parent2)
			return;

		//we will take union of two nodes
		size--;
		
		if(parent1.rank >= parent2.rank)
		{
			parent2.parent = parent1;
			
			if(parent1.rank == parent2.rank)
			{
				parent1.rank++;
			}
		}
		else
		{
			parent1.parent = parent2;
		}
	}
	
	int findSet(int val)
	{
		Node node = map.get(val);
		Node parent = findSet(node);
		return parent.val;
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

class Node
{
	int val;
	int rank;
	Node parent;	
}