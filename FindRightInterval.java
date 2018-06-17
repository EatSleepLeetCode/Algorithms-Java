import java.util.Arrays;

public class FindRightInterval 
{
    public int[] findRightInterval(Interval[] intervals) 
    {
        int n = intervals.length;
        int[] result = new int[n];
        result[0] = -1;
        
        if (n == 1) return result;
        
        Interval[] temp = new Interval[n];
        
        //O (n)
        for (int i = 0; i < n; i++)
        {
            temp[i] = new Interval(intervals[i].start, i);
        }
        
        //O (n log n)
        Arrays.sort(temp, (a, b) -> a.start - b.start);
        
        //O (n log n)
        for (int i = 0; i < n; i++)
        {
            int left = 0;
            int right = n - 1;
            int index = -1;
            
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                
                if (temp[mid].start == intervals[i].end)
                {
                    index = temp[mid].end;
                    break;
                }
                else if (temp[mid].start > intervals[i].end)
                {
                    index = temp[mid].end;
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            result[i] = index;
        }
        
        return result;
    }
}


class Interval 
{
	int start;
	int end;
	Interval() 
	{ 
		start = 0; 
		end = 0; 
	}
	
	Interval(int s, int e) 
	{ 
		start = s; 
		end = e; 
	}
}