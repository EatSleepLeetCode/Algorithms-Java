import java.util.Arrays;

public class IntersectionSizeTwo 
{
    public int intersectionSizeTwo(int[][] intervals) 
    {
    	//Reason for ascending sort on Start of an interval is that the chances of
    	//overlap of that interval with previous intervals is possible; however, if
    	//we started from End of an interval then overlap may or may not happen.
    	//Reason for descending sort on End of an interval is to avoid the case where
    	//todo for an intervals becomes becomes 0 due to incorrect attribution.
    	//E.g. [1,2] [2,3] [2,4] 4,5]
    	//Interval [4, 5] in outer loop: Execution of 4 will set todo as 2, 2, 1*, 1*
    	//Interval [4, 5] in outer loop: Execution of 5 will set todo as 2, 2, 1, 0*
    	//Interval [2, 4] in outer loop: Execution of 2 will set todo as 1*, 1*, 0*, 0
    	//Interval [2, 4] in outer loop: Execution of 3 not executed
    	//Interval [2, 4] in outer loop: Execution of 4 not executed
    	//Interval [2, 3] in outer loop: Execution of 2 will set todo as 0*, 0*, 0, 0
    	//The problem happens that [1,2]'s todo becomes 0 by doing todo-- for 2 twice
    	//instead of doing of doing it once for 1 and once for 2.
        
    	Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = intervals.length;
        int[] todo = new int[n];
        Arrays.fill(todo, 2);
        
        int result = 0;
        
        for(int i = n - 1; i >= 0; i--)			//Loop over all intervals
        {
            int start = intervals[i][0];
            int intersectReq = todo[i];
            
            for(int elem = start; elem < start + intersectReq; elem++)
            {
                for(int j = 0; j <= i; j++)		//Loop over all unseen intervals from 0 to i 
                {
                    if(todo[j] > 0 && elem <= intervals[j][1])
                    {
                        todo[j]--;
                    }
                }
                result++;
            }            
        }
        return result;
    }
	public static void main(String[] args) 
	{
		IntersectionSizeTwo obj = new IntersectionSizeTwo();
		int[][] intervals = new int[][] {{1, 2},{2, 3},{2, 4},{4, 5}};
		System.out.println(obj.intersectionSizeTwo(intervals));
	}
}
