import java.util.HashMap;
import java.util.Map;

class TwoSumIII
{
    private Map<Integer, Integer> map;
    
    //Initialize your data structure here
    public TwoSumIII()
    {
        map = new HashMap<Integer, Integer>();
    }
    
    //Add number to an internal data structure
    public void add(int number)
    {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    //Find if there exists any pair of numbers for which sum equals to the value
    boolean find(int value)
    {
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int num1 = entry.getKey();
            
            int num2 = value - entry.getKey();
            
            if((num1 == num2 && entry.getValue() > 1) || (num1 != num2 && map.containsKey(num2)))
            {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) 
	{
		TwoSumIII obj = new TwoSumIII();
		obj.add(0);
		obj.add(1);
		obj.add(3);
		obj.add(3);
		obj.add(7);
		System.out.println(obj.find(6));
		System.out.println(obj.find(7));
	}
}