import java.util.HashMap;
import java.util.Map;

public class RedundantConnections2 
{	
	public static void main(String[] args) 
	{
		RedundantConnections2 obj = new RedundantConnections2();
//		int[] result = obj.findRedundantDirectedConnection(new int[][] {{2,4},{3,4},{1,4},{2,5},{4,5}});
		int[] result = obj.findRedundantDirectedConnection(new int[][] {{1,2},{1,3},{2,3}});
		System.out.println(result[0] + ":" + result[1]);
	}
	
    public int[] findRedundantDirectedConnection(int[][] edges) 
    {
        DisjointSet ds = new DisjointSet();
        Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        
        int[] cand1 = new int[]{-1, -1};
        int[] cand2 = new int[]{-1, -1};
        
        //Find candidates based on the condition, 
        //if a node has more than one parent
        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            
            if(!parentMap.containsKey(dest))
            {
                parentMap.put(dest, src);
            }
            else												//current dest has another parent
            {
                cand2 = new int[] {src, dest};					//cand2 is the current edge              	   
                cand1 = new int[] {parentMap.get(dest), dest};	//cand1 is the already existing edge from another parent
                
                edge[1] = 0;									//break the current edge
            }                    
        }
        
        
        //Do union find to check if cycle exists
        //Cycle may exist even after breaking the edge above
        //Cycle may also exist even when no node has multiple parents e.g. 1->2->3->1
        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            
            ds.makeSet(src);
            
            if(dest == 0)			//if it's broken edge then skip
                continue;
            
            ds.makeSet(dest);
            
            int parent1 = ds.findSet(src);
            int parent2 = ds.findSet(dest);
            
            if(parent1 == parent2)	//cycle exists
            {
            	//there is cycle but there isn't any node with multiple parents, so return current edge
                if(cand1[0] == -1)	
                {
                    return edge;
                }
              //there is cycle and there exists a node with multiple parents even after breaking an edge of cand2
              //So return cand1 because we didn't break its edge
                return cand1;		
            }                          
            ds.union(src, dest);            
        }
        //Graph was valid i.e. no cycle were found after breaking an edge corresponding to cand2 then cand2 is answer
        return cand2;
    }
}

class DisjointSet
{
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    
    void makeSet(int val)
    {
        if(map.containsKey(val))
            return;
        
        Node node = new Node(val);
        map.put(val, node);
    }
    
    void union(int val1, int val2)
    {
        Node node1 = map.get(val1);
        Node node2 = map.get(val2);
        
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        
        if(parent1 == parent2)
            return;
        
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
    
    public Node(int val)
    {
        this.val = val;
        this.rank = 0;
        this.parent = this;
    }
}