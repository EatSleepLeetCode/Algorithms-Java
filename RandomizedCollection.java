import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

class RandomizedCollection 
{
    Map<Integer, LinkedHashSet<Integer>> map = new HashMap<Integer, LinkedHashSet<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    java.util.Random rand = new java.util.Random();
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) 
    {
    	boolean notPresent = false;
        if(!map.containsKey(val))
        {
        	notPresent = true;
        	map.put(val, new LinkedHashSet<Integer>());
        }
        
        map.get(val).add(list.size());
        list.add(val);            
        
        return notPresent;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) 
    {
        if(map.containsKey(val))
        {
            int index = map.get(val).iterator().next();
            //Important - Remove from map here e.g. if we have 4 - [0, 2, 4] in map and list has size 5 i.e. last index is 4
            //If we have to remove 4 then the below line will remove 0 from 4's LinkedHashSet. Then we find the last index of 4
            //it's 4 so we will enter the below index != list.size() - 1 block and we move the 4 from lastIndex in the 
            //LinkedHashSet and to the index that's getting removed i.e. 0 in this case. So we remove 4 from LinkedHashSet
            //and add 0. And, it becomes 4 - [2, 0]. However, if we wait to execute the belwo line after the 
            //index != list.size() - 1 block then we would have already removed 4 and added 0 in this block and then we end up 
            //removing 0 again so leaving LinkedHashSet as 4 - [2] is not correct.
            
            map.get(val).remove(index);
            
            if(index != list.size() - 1)
            {
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                map.get(lastVal).remove(list.size() - 1);                                
                map.get(lastVal).add(index);                                
            }
                        
            if(map.get(val).size() == 0)
                map.remove(val);
            
            list.remove(list.size() - 1);
            
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() 
    {
        return list.get(rand.nextInt(list.size()));
    }
    
	public static void main(String[] args) 
	{
		RandomizedCollection obj = new RandomizedCollection();
//		Input 1
//		obj.insert(1);
//		obj.insert(1);
//		obj.remove(1);
//		obj.getRandom();
		
//		Input 2
//		obj.insert(0);
//		obj.insert(1);
//		obj.insert(2);
//		obj.insert(3);
//		obj.insert(3);
//		obj.remove(2);
//		obj.remove(3);
//		obj.remove(0);
//		obj.getRandom();
//		obj.getRandom();
//		obj.getRandom();
//		obj.getRandom();
		
//		Input 3
		obj.insert(4);
		obj.insert(3);
		obj.insert(4);
		obj.insert(2);
		obj.insert(4);
		obj.remove(4);
		obj.remove(3);
		obj.remove(4);
		obj.remove(4);		
	}
}
