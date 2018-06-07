import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MaxChunksToMakeSortedBothVers 
{   
	 public int maxChunksToSorted(int[] arr) 
	 {
		 int result = 0;
		 int n = arr.length;
		 int[] maxLeft = new int[n];
		 int[] minRight = new int[n];
		 
		 maxLeft[0] = arr[0];
		 for(int i = 1 ; i < n; i++)
		 {
			 maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
		 }

		 minRight[n - 1] = arr[n - 1];
		 for(int i = n - 2; i >= 0; i--)
		 {
			 minRight[i] = Math.min(minRight[i + 1], arr[i]);
		 }
		 
		 for(int i = 0 ; i < n - 1; i++)
		 {
			 if(maxLeft[i] <= minRight[i + 1])
			 {
				 result++;
			 }
		 }
		 
		 return result + 1;
	 }
	 
	public static void main(String[] args) 
	{
		MaxChunksToMakeSortedBothVers obj = new MaxChunksToMakeSortedBothVers();
		int[] arr = new int[] {4,3,2,1,0};
		System.out.println(obj.maxChunksToSorted(arr));
		
		arr = new int[] {0,1,2,3,4};
		System.out.println(obj.maxChunksToSorted(arr));
		
		arr = new int[] {1,0,2,3,4};
		System.out.println(obj.maxChunksToSorted(arr));
	}
}
