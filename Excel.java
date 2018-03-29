import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Excel
{
  class Cell
  {
    int value;
    Map<String, Integer> children;
    
    public Cell(int value, Map<String, Integer> children)
    {
      this.value = value;
      this.children = children;
    }      
  }
  
  Cell[][] form;
  Stack<int[]> stack;
  
  public Excel(int H, char W)
  {
 	form = new Cell[H][W - 'A' + 1];
    stack = new Stack<int[]>();
  }
  
  public void set(int row, char col, int value)
  {
    form[row - 1][col - 'A'] = new Cell(value, new HashMap<String, Integer>());
    topologicalSort(row - 1, col - 'A');
    sumStack();
  }
  
  public int get(int row, char col)
  {
    if(form[row - 1][col - 'A'] == null)
      return 0;
    
    return form[row - 1][col - 'A'].value;
  }
  
  public int sum(int row, char col, String[] strs)
  {
    Map<String, Integer> range = convertToMap(strs);
    int sum = getSum(row - 1, col - 'A', range);
    set(row, col, sum);
    form[row - 1][col - 'A'] = new Cell(sum, range);
    return sum;
  }
  
  private void sumStack()
  {
    while(!stack.isEmpty())
    {
      int[] vals = stack.pop();
      
      Cell cell = form[vals[0]][vals[1]];
      
      if(cell.children.size() > 0)
        getSum(vals[0], vals[1], cell.children);
    }
  }
    
  private int getSum(int row, int col, Map<String, Integer> children)
  {
    int sum = 0;
    for(String child : children.keySet())
    {
      int childCol = child.charAt(0) - 'A';
      int childRow = Integer.parseInt(child.substring(1)) - 1;
      
      sum = sum + (form[childRow][childCol] == null ? 0 : form[childRow][childCol].value) * children.get(child);
    }
    
    form[row][col] = new Cell(sum, children);
    return sum;
  }
            
  private Map<String, Integer> convertToMap(String[] strs)
  {
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    for(String str : strs)
    {
      if(str.indexOf(":") < 0)
        map.put(str, map.getOrDefault(str, 0) + 1);
      else
      {
        String[] range = str.split(":");
        
        char col1 = range[0].charAt(0);
        int row1 = Integer.parseInt(range[0].substring(1));
        
        char col2 = range[1].charAt(0);
        int row2 = Integer.parseInt(range[1].substring(1));
		
        for(int i = row1; i <= row2; i++)
        {
          for(char j = col1; j <= col2; j++)
          {
			String key = "" + j + i;
            map.put(key, map.getOrDefault(key, 0) + 1);
          }
        }
      }
    }
    return map;
  }
          
  private void topologicalSort(int row, int col)
  {
    for(int i = 0; i < form.length; i++)
    {
      for(int j = 0; j < form[i].length; j++)
      {
        if(form[i][j] != null && form[i][j].children.containsKey("" + (char)(col + 'A') + (row + 1)))
        {
          topologicalSort(i, j);
        }
      }
    }
    stack.push(new int[]{row, col});
  }
  
  public static void main(String[] args)
  {
    Excel obj = new Excel(3, 'C');
    obj.set(1, 'A', 2);
    System.out.println(obj.sum(3, 'C', new String[]{"A1", "A1:B2"}));    
    obj.set(2, 'B', 3);
	System.out.println(obj.get(3, 'C'));	//Changes to 2B were propagated
    System.out.println(obj.sum(3, 'C', new String[]{"A1", "A1:B2"}));
  }
}

// Excel(3,"C"); 
// construct a 3*3 2D array with all zero.
//   A B C
// 1 0 0 0
// 2 0 0 0
// 3 0 0 0

// set C(1,"A") to be 2.
//   A B C
// 1 2 0 0
// 2 0 0 0
// 3 0 0 0

// sum(3, "C", ["A1", "A1:B2"]);
// set C(3,"C") to be the sum of value at C(1,"A") and the values sum of the rectangle range whose top-left cell is C(1,"A") and bottom-right cell is C(2,"B"). Return 4. 
//   A B C
// 1 2 0 0
// 2 0 0 0
// 3 0 0 4

// set(2, "B", 2);
// set C(2,"B") to be 2. Note C(3, "C") should also be changed.
//   A B C
// 1 2 0 0
// 2 0 2 0
// 3 0 0 6
