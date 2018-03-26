import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle 
{
    public int slidingPuzzle(int[][] board) 
    {
        String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = board.length, cols = board[0].length;
        int startRow = 0, startCol = 0;
        
        search:                             //Important: break out of inner and outer loop
            for (startRow = 0; startRow < rows; startRow++)
                for (startCol = 0; startCol < cols; startCol++)
                    if (board[startRow][startCol] == 0) 
                        break search;

        Node start = new Node(board, startRow, startCol);
        if(target.equals(start.boardstring)) return 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);

        Set<String> seen = new HashSet<String>();
        seen.add(start.boardstring);
        int depth = 0;
        
        while (!queue.isEmpty()) 
        {
        	depth++;                                    //Important
        	int size = queue.size();        	
        	for(int i = 0; i < size; i++)
        	{
                Node curr = queue.poll();
                for (int[] dir: dirs) 
                {
                    int neiRow = dir[0] + curr.zero_r;
                    int neiCol = dir[1] + curr.zero_c;
                    if (neiRow < 0 || neiRow >= rows || neiCol < 0 || neiCol >= cols)
                        continue;

                    int[][] newboard = new int[rows][cols];
                    int rowIndex = 0;
                    for (int[] row: curr.board)               //Copy the contents of board
                        newboard[rowIndex++] = row.clone();
                    
                    newboard[curr.zero_r][curr.zero_c] = newboard[neiRow][neiCol];  //swap
                    newboard[neiRow][neiCol] = 0;                                   

                    Node nei = new Node(newboard, neiRow, neiCol);
                    
                    if (nei.boardstring.equals(target)) 
                        return depth;
                    
                    if (!seen.contains(nei.boardstring))
                    {
                        queue.offer(nei);
                        seen.add(nei.boardstring);
                    }
                }
        	}
        }
        return -1;
    }
    
	public static void main(String[] args) 
	{
		SlidingPuzzle obj = new SlidingPuzzle();
		System.out.print(obj.slidingPuzzle(new int[][] {{4,1,2}, {5,0,3}}));
	}
}

class Node 
{
    int[][] board;
    String boardstring;
    int zero_r;
    int zero_c;
    
    Node(int[][] board, int row, int col) 
    {
        this.board = board;
        boardstring = Arrays.deepToString(board);
        zero_r = row;
        zero_c = col;
    }
}