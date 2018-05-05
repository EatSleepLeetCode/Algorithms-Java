import java.util.ArrayList;
import java.util.List;

//If 222 is pressed then it could mean -> AAA, AB, BA, C
public class PhoneDecode 
{
	//We compress string based on digits and store their frequencies 
	//i.e. 222 55 666 -> 2[3] 5[2] 6[3] -> freqs[3, 2, 3]
	//Now, we need to find the number of ways we can add digits to get the desired sum i.e frequency
	//We will map A = 1, B = 2, C = 3 and now the problem reduces to combination sum where 
	//frequency is the sum and numbers are {1, 2, 3}. We can further simplify the problem by using 
	//same mapping scheme for all digits e.g. 555 i.e. J = 1, K = 2, L = 3.
	//Below code assumes all digits correspond to 3 chars i.e. ignoring special case7 & 9 (PQRS and WXYZ)
	
	int findWays(String input)
	{
		int result = 0;
		int[] digitMap = new int[] {1, 2, 3};
		List<Integer> freqs = new ArrayList<Integer>();
		compressString(input, freqs);
		
		for(int i = 0; i < freqs.size(); i++)
		{
			result += combinationSum(digitMap, freqs.get(i), 0);
		}
		return result;
	}

	void compressString(String input, List<Integer> freqs)
	{
		int n = input.length();
		int index = 0;
		int count = 0;
		
		while(index < n)
		{
			char ch = input.charAt(index);
			count = 0;
			while(index < n && ch == input.charAt(index))
			{
				count++;
				index++;
			}
			freqs.add(count);
		}
	}

	int combinationSum(int[] nums, int tgt, int curr)
	{
		if(curr == tgt)
			return 1;
		
		int count = 0;

		for(int i = 0; i < nums.length; i++)
		{
			if(curr + nums[i] > tgt)
				continue;
			
			count += combinationSum(nums, tgt, curr + nums[i]);
		}
		return count;
	}
	
	public static void main(String[] args) 
	{
		PhoneDecode obj = new PhoneDecode();
		System.out.println(obj.findWays("223334"));
	}
}
