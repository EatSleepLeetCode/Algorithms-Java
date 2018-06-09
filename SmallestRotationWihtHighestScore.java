
public class SmallestRotationWihtHighestScore 
{
	int bestRotation(int[] A)
	{
		int n = A.length;
		int curr = 0;
		int best = Integer.MIN_VALUE;	//Holds the value of minimum points lost 
		int result = -1;
		int[] bad = new int[n];		
		
		for (int i = 0; i < n ; i++)
		{
			int left = (i - A[i] + 1 + n) % n;
			int right = (i + 1) % n;
			bad[left]--;
			bad[right]++;
			
			if (left > right)
			{
				bad[0]--;
			}
		}
		
		for (int i = 0; i < n; i++)
		{
			curr += bad[i];
			
			if (curr > best)
			{
				best = curr;
				result = i;
			}
		}		
		
		return result;		
	}
	
	public static void main(String[] args) 
	{
		SmallestRotationWihtHighestScore obj = new SmallestRotationWihtHighestScore();
		System.out.println(obj.bestRotation(new int[] {2, 3, 1, 4, 0}));
	}
}
