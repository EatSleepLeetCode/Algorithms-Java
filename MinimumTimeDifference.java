import java.util.List;

public class MinimumTimeDifference 
{
    public int findMinDifference(List<String> timePoints) 
    {
        boolean[] time = new boolean[24 * 60];
        
        for (String str : timePoints)
        {            
            int hh = Integer.parseInt(str.substring(0, 2));
            int mm = Integer.parseInt(str.substring(3));
            
            if (time[hh * 60 + mm])
                return 0;
            
            time[hh * 60 + mm] = true;
        }
        
        int prev = 0;
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        
        for (int i = 0; i < 24 * 60; i++)
        {
            if (time[i])
            {
                if (first != Integer.MAX_VALUE)
                {
                    min = Math.min(min, i - prev);      //keep updating min difference
                }
                
                first = Math.min(first, i);             //keep track of first existing time tick
                last = Math.max(last, i);               //keep track of last existing time tick
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));  //find difference between first and last
        
        return min;
    }
}
