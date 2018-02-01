import java.util.ArrayList;
import java.util.List;

public class MovingAverage 
{

	void findMovingAvg(int[] nums, int k)
	{
		int n = nums.length;
		List<Double> result = new ArrayList<Double>();
		Double sum = 0.0;
		
		for(int i = 0; i < k - 1; i++)
		{
			sum += nums[i];
		}
		
		for(int i = k - 1; i < n; i++)
		{
			sum += nums[i];
			result.add(sum / k);
			sum -= nums[i - k + 1];
		}
		
		for(Double avg : result)
			System.out.println(avg);
	}
	
	public static void main(String[] args) 
	{
		MovingAverage obj = new MovingAverage();
		obj.findMovingAvg(new int[] {1,2,3,4,5,6}, 3);
	}
}
