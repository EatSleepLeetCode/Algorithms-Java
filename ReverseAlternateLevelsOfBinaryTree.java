
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node
{
	char val;
	Node left;
	Node right;
	public Node (char val)
	{
		this.val = val;
	}
}

public class ReverseAlternateLevelsOfBinaryTree 
{
	//Solution - 1
	void reverseAlternate(Node node)
	{
		reverse(node.left,node.right,true);
	}
	
	void reverse(Node l, Node r, boolean flag)
	{
		if(l==null || r==null)
			return;
		     
		if(flag)
			swap(l, r);
		     
		reverse(l.left,r.right,!flag); // swap value of 1st left subtree with right most e.g. d & g
		reverse(l.right,r.left,!flag); //swap value of right subtree with left most of another subtree e.g. e and f 
	}
	 
	void swap(Node left,Node right)
	{
		char l=left.val;
		left.val=right.val;
		right.val=l;
	}
	
	//Solution - 2
	List<List<Character>> levels = new ArrayList<List<Character>>();
	
	void reverseAlternateLevels(Node root)
	{
		reverseLevels(root, false);
		reverseLevels(root, true);
	}
	void reverseLevels(Node root, boolean update)
	{
		int size = 0;
		int level = 0;
		Queue<Node> q = new LinkedList<Node>();		
		q.offer(root);
		
		while(!q.isEmpty())
		{
			size = q.size();
			List<Character> temp = new ArrayList<Character>();
			for(int i = 0; i < size; i++)
			{
				Node curr = q.poll();
				temp.add(curr.val);
				
				if(update)
					curr.val = levels.get(level).get(i);
				
				if(curr.left != null)
					q.offer(curr.left);
				
				if(curr.right != null)
					q.offer(curr.right);
			}
			
			if(!update)
			{
				if(level % 2 != 0)				//bcoz we will reverse odd levels
					Collections.reverse(temp);
				
				levels.add(level, temp);
			}
			
			level++;
		}		
	}
	
	//Helper function for printing tree
	public void levelOrderQueue(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		int levelNodes = 0;
		
		if(root==null) 
			return;
		
		q.offer(root);

		while(!q.isEmpty())
		{
			levelNodes = q.size();
			while(levelNodes > 0)
			{
				Node n = q.poll();
				System.out.print("" + n.val);
				
				if(n.left!=null) 
					q.add(n.left);
				if(n.right!=null) 
					q.add(n.right);
				
				levelNodes--;
			}
			System.out.println("");
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node('a');
		root.left = new Node ('b');
		root.right = new Node ('c');
		root.left.left = new Node ('d');
		root.left.right = new Node ('e');
		root.right.left = new Node ('f');
		root.right.right = new Node ('g');
		root.left.left.left = new Node ('1');
		root.left.left.right = new Node ('2');
		root.left.right.left = new Node ('3');
		root.left.right.right = new Node ('4');

		root.right.left.left = new Node ('5');
		root.right.left.right = new Node ('6');
		root.right.right.left = new Node ('7');
		root.right.right.right = new Node ('8');

		ReverseAlternateLevelsOfBinaryTree obj = new ReverseAlternateLevelsOfBinaryTree();
		System.out.println("Orininal Tree");
		obj.levelOrderQueue(root);

		//Both solutions just update the value of nodes and not actually swap the child nodes
		
		//Solution 1
		obj.reverseAlternate(root);
		
		//Solution 2 - This solution is better
		obj.reverseAlternateLevels(root);
		
		System.out.println("\n New Tree, Alternate Levels Reversed..");
		obj.levelOrderQueue(root);
	}
}