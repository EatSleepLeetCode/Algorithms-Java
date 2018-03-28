
public class LongestSubstringWithAtmostKDistinct 
{
	int longestSubstringWithAtMostKDistinct(String str, int k)
	{
		int result = Integer.MIN_VALUE;
		int left  = 0;
		int right = 0;
		int n = str.length();
		int counter= 0;
		int[] map = new int[26];
		
		if(n == 0 || k <= 0)
			return 0;
		
		while(right < n)
		{
			char ch = str.charAt(right);
			
			if(map[ch - 'a'] == 0)
			{
				counter++;
			}
			map[ch - 'a']++;
			right++;
			
			while(counter > k)
			{
				if(map[str.charAt(left) - 'a'] > 0)
				{
					map[str.charAt(left) - 'a']--;
					if(map[str.charAt(left) - 'a'] == 0)
						counter--;
				}
				left++;
			}
			
			result = Math.max(result, right - left);
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		LongestSubstringWithAtmostKDistinct obj = new LongestSubstringWithAtmostKDistinct();
		System.out.println(obj.longestSubstringWithAtMostKDistinct("eceba", 2));
	}
}
