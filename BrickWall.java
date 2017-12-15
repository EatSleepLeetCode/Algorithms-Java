import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall 
{
    public int leastBricks(List<List<Integer>> wall) 
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxFreqPosition = 0;
        int length = 0;
            
        int rows = wall.size();
        
        for(int i = 0; i < rows; i++)
        {
            int cols = wall.get(i).size();
            length = 0;
            
            for(int j = 0; j < cols - 1; j++)
            {
                length += wall.get(i).get(j);
                
                map.put(length, map.getOrDefault(length, 0) + 1);
                
                maxFreqPosition = Math.max(maxFreqPosition, map.get(length));
            }
        }
        return rows - maxFreqPosition;
    }	
	public static void main(String[] args) 
	{
		BrickWall obj = new BrickWall();
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(2);
		input1.add(2);
		input1.add(1);
		input.add(input1);

		input1 = new ArrayList<Integer>();
		input1.add(3);
		input1.add(1);
		input1.add(2);
		input.add(input1);

		input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(3);
		input1.add(2);
		input.add(input1);

		input1 = new ArrayList<Integer>();
		input1.add(2);
		input1.add(4);
		input.add(input1);

		input1 = new ArrayList<Integer>();
		input1.add(3);
		input1.add(1);
		input1.add(2);
		input.add(input1);

		input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(3);
		input1.add(1);
		input1.add(1);
		input.add(input1);
		
		System.out.println(obj.leastBricks(input));
	}
}
