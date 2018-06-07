import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWndowMedian 
{
    public double[] medianSlidingWindow(int[] nums, int k) 
    {        
        double[] result = new double[nums.length - k + 1];
        
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
        PriorityQueue<Integer> min = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));
        
        for(int i = 0; i < nums.length; i++) 
        {
            max.offer(nums[i]);
            min.offer(max.poll());

            if(max.size() < min.size())
                max.offer(min.poll());

            if(max.size() + min.size() == k) 
            {
                double median;
                if(max.size() > min.size()) 
                    median = (double) max.peek();
                else 
                    median = (double)((long)max.peek() + (long) min.peek()) / 2;

                int start = i - k + 1;
                result[start] = median;
                if(!max.remove(nums[start])) 
                {
                    min.remove(nums[start]);
                }
            }
        }
        return result;
    }
	public static void main(String[] args) 
	{
		SlidingWndowMedian obj = new SlidingWndowMedian();
		obj.medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 6);
	}
}
