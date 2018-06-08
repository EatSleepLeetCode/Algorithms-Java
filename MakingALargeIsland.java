
class MakingALargeIsland 
{
    public int largestIsland(int[][] grid) 
    {        
        DisjointSet ds = new DisjointSet();
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 1;     //Min. possible area is 1 because if everything is 0 then we will flip atleast one 0

        //Make set for cells
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 1)
                {
                    ds.makeSet(i * cols + j);   // Get unique cell id by: i * cols + j
                }
            }
        }

        //Take union with neighboring cells with value 1
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] != 1) continue;
                
                for (int[] dir : dirs)
                {
                    int neiRow = i + dir[0];
                    int neiCol = j + dir[1];

                    if (neiRow < 0 || neiRow >= rows ||neiCol < 0 || 
                        neiCol >= cols ||grid[neiRow][neiCol] == 0)
                        continue;
                        
                    ds.union(i * cols + j, neiRow * cols + neiCol);
                    
                    int parent = ds.findSet(i * cols + j);
                    result = Math.max(result, ds.getArea(parent));  //Keep updating result in case there are no 0's
                }
            }
        }
        
        //Try finding max possible area by combining neighbors for cells with value 0
        int combinedArea = 0;
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {                
                combinedArea = 1;
                
                if (grid[i][j] != 0) continue;
                
                Set<Integer> parentSet = new HashSet<Integer>();

                for (int[] dir : dirs)
                {
                    int neiRow = i + dir[0];
                    int neiCol = j + dir[1];

                    if (neiRow < 0 || neiRow >= rows ||neiCol < 0 || 
                        neiCol >= cols ||grid[neiRow][neiCol] == 0)
                        continue;
                    
                    int neiParent = ds.findSet(neiRow * cols + neiCol);
                    
                    if (!parentSet.contains(neiParent))
                    {
                        parentSet.add(neiParent);
                        combinedArea += ds.getArea(neiParent);                    
                    }
                }
                result = Math.max(result, combinedArea);
            }
        }
        return result;
    }
}

class Node
{
    int val;
    Node parent;
    int rank;
    int area;
}

class DisjointSet
{
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    
    void makeSet(int val)
    {
        Node node = new Node();
        node.val = val;
        node.parent = node;
        node.rank = 0;
        node.area = 1;
        map.put(val, node);
     }
    
    void union(int val1, int val2)
    {
        Node node1 = map.get(val1);
        Node node2 = map.get(val2);
        
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        
        if (parent1 == parent2)
            return;
        
        if (parent1.rank >= parent2.rank)
        {
            parent2.parent = parent1;
            parent1.area += parent2.area;       //Special
            
            if (parent1.rank == parent2.rank)
            {
                parent1.rank++;
            }
        }
        else
        {
            parent1.parent = parent2;
            parent2.area += parent1.area;       //Special
        }
    }
    
    int findSet(int nodeVal)
    {
        Node node = map.get(nodeVal);
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
    
    int getArea(int nodeVal)
    {
        return map.get(nodeVal).area;
    }
}