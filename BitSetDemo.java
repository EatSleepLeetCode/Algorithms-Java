import java.util.BitSet;

public class BitSetDemo 
{
	void bitSetFun(int rows, int cols)
	{
		BitSet[] visited = new BitSet[rows];
		
		for(int i = 0; i < rows; i++)
		{
			//No need to specify column dimension
			visited[i] = new BitSet();
		}
		
		//.set(x) sets the bit for xth index
		//We are setting the diagonal
		visited[0].set(0);
		visited[1].set(1);
		visited[2].set(2);
		visited[3].set(3);
		
		print(visited);
	}
	
	void print(BitSet[] visited)
	{
		int rows = visited.length;
		
		for(int i = 0; i < rows; i++)
		{
			//For testing purposes we are using cols as 5.
			//In reality we won't need to print it. So calling get(x) will be sufficient and
			//we don't need to know the set size.
			
			for(int j = 0; j < 80; j++)
			{
				//.get(x) return true if bit at xth index is set, false otherwise
				System.out.print(visited[i].get(j) ? "1" : "0");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		BitSetDemo obj = new BitSetDemo();
		obj.bitSetFun(4, 5);
	}
}
