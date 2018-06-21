import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements 
{
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
    	List<Integer> myList = new ArrayList<Integer>();
    	
    	for (int num : arr)
    		myList.add(num);
        
        Collections.sort(myList, (a, b) -> Integer.compare(Math.abs(a - x), Math.abs(b - x)));
        
        myList = myList.subList(0, k);
        
        Collections.sort(myList);
        
        return myList;
    }
    
	public static void main(String[] args) 
	{
		FindKClosestElements obj = new FindKClosestElements();
		System.out.println(obj.findClosestElements(new int[] {1,2,3,4,5}, 4, 3));
		System.out.println(obj.findClosestElements(new int[] {1,2,3,4,5}, 4, -1));
	}
}
