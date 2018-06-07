import java.util.ArrayList;
import java.util.List;

public class SlidingWindowAverage 
{
	void findMovingAvg(int[] nums, int k)
	{
		int n = nums.length;
		List<Double> result = new ArrayList<Double>();
		Double sum = 0.0;
		
		for(int i = 0; i < k; i++)
		{
			sum += nums[i];
		}
		
		for(int i = k; i < n; i++)
		{
			result.add(sum / k);
			sum += nums[i];
			sum -= nums[i - k];
		}

		result.add(sum / k);
		
		for(Double avg : result)
			System.out.println(avg);
	}
	
	public static void main(String[] args) 
	{
		SlidingWindowAverage obj = new SlidingWindowAverage();
		obj.findMovingAvg(new int[] {1,2,3,4,5,6}, 3);
	}
}
