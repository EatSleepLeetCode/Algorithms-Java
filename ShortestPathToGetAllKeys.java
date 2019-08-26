class ShortestPathToGetAllKeys 
{
    public int shortestPathAllKeys(String[] grid) 
    {
        int x = -1, y = -1, rows = grid.length, cols = grid[0].length(), max = -1;
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                char ch = grid[i].charAt(j);
                
                if (ch == '@')
                {
                    x = i;
                    y = j;
                }
                
                if (ch >= 'a' && ch <= 'f')
                    max = Math.max(max, ch - 'a' + 1);
            }
        }
        
        State start = new State(0, x, y);
        Queue<State> q = new LinkedList<State>();
        Set<String> visited = new HashSet<String>();
        visited.add(0 + " " + x + " " + y);
        q.offer(start);
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = -1;
        
        while (!q.isEmpty())
        {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                State curr = q.poll();
                
                if (curr.keys == (1 << max) - 1)
                    return step;
                
                for (int[] dir : dirs)
                {
                    int neiRow = curr.i + dir[0];
                    int neiCol = curr.j + dir[1];
                    int keys = curr.keys;
                    
                    if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols )
                        continue;
                    
                    char ch = grid[neiRow].charAt(neiCol);                    
                    if (ch == '#') continue;
                    
                    if (ch >= 'a' && ch <= 'f') keys |= 1 << (ch - 'a');
                    if (ch >= 'A' && ch <= 'F' && ((keys >> (ch - 'A')) & 1) == 0) 
                        continue;
                    if (!visited.contains(keys + " " + neiRow + " " + neiCol))
                    {
                        visited.add(keys + " " + neiRow + " " + neiCol);
                        q.offer(new State(keys, neiRow, neiCol));
                    }
                }
            }
        }
        return -1;
    }
}

class State
{
    int keys;
    int i;
    int j;
    
    public State(int keys, int i, int j)
    {
        this.keys = keys;
        this.i = i;
        this.j = j;
    }
}
