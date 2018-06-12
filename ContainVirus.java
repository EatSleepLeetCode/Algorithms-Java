import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainVirus  
{
    Set<Integer> visited;
    List<Set<Integer>> regions;
    List<Set<Integer>> frontiers;
    List<Integer> perimeters;
    int[][] grid;
    int rows; 
    int cols;    
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int containVirus(int[][] grid) 
    {
        int ans = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        
        while (true)
        {
            visited = new HashSet<Integer>();
            regions = new ArrayList<Set<Integer>>();
            frontiers = new ArrayList<Set<Integer>>();
            perimeters = new ArrayList<Integer>();
            
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    if (grid[row][col] == 1 && !visited.contains(row * cols + col))
                    {
                        regions.add(new HashSet<Integer>());
                        frontiers.add(new HashSet<Integer>());
                        perimeters.add(0);
                        dfs(row, col);
                    }
                }
            }
            
            if (regions.isEmpty())
                break;
            
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); i++)
            {
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                {
                    triageIndex = i;
                }
            }
            
            ans += perimeters.get(triageIndex);                 //New walls built
            
            for (int i = 0; i < regions.size(); i++)
            {
                if (i == triageIndex)
                {
                    for (int code : regions.get(i))
                    {
                        grid[code / cols][code % cols] = -1;    //Denote wall as -1
                    }
                }
                else
                {
                    for (int code : regions.get(i))
                    {
                        int row = code / cols;
                        int col = code % cols;
                        
                        for (int[] dir : dirs)
                        {
                            int neiRow = row + dir[0];
                            int neiCol = col + dir[1];
                            
                            if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols || grid[neiRow][neiCol] != 0)
                                continue;
                            
                            grid[neiRow][neiCol] = 1;       //Infected
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    void dfs(int row, int col)
    {        
        visited.add(row * cols + col);
        int n = regions.size();
        regions.get(n - 1).add(row * cols + col);
        
        for (int[] dir : dirs)
        {
            int neiRow = row + dir[0];
            int neiCol = col + dir[1];
            
            if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols || visited.contains(neiRow * cols + neiCol))
                continue;
            
            if (grid[neiRow][neiCol] == 1)
            {
                dfs(neiRow, neiCol);
            }
            else if(grid[neiRow][neiCol] == 0)
            {
                frontiers.get(n - 1).add(neiRow * cols + neiCol);
                perimeters.set(n - 1, perimeters.get(n - 1) + 1);
            }            
        }
    }
}