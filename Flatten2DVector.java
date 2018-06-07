import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flatten2DVector 
{
	List<List<Integer>> vector;
	int rowId;
	int colId;
	int numRows;
	
	public Flatten2DVector(List<List<Integer>> vector)
	{
		this.vector = vector;
		this.rowId= 0;
		this.colId= 0;
		this.numRows = vector.size();
	}
	
	int next()
	{
		int result = 0;
		if(colId < vector.get(rowId).size())
		{
			result = vector.get(rowId).get(colId);
		}
		
		colId++;
		
		if(colId == vector.get(rowId).size())
		{
			colId = 0;
			rowId++;
		}
		
		return result;
	}
	
	boolean hasNext()
	{
		while(rowId < numRows && (vector.get(rowId) == null || vector.get(rowId).size() == 0))
			rowId++;
		
		return (vector != null && vector.size() != 0 && rowId < numRows);
	}
	
	public static void main(String[] args) 
	{
		List<List<Integer>> vector = new ArrayList<List<Integer>>();
		vector.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		vector.add(new ArrayList<Integer>(Arrays.asList(3)));
		vector.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		
		Flatten2DVector obj = new Flatten2DVector(vector);
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());		
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
	}
}
