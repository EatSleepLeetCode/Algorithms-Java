
public class KMP 
{
	boolean patternFound(String input, String pattern)
	{
		
		int[] prefixArr = new int[pattern.length()];
		buildPrefixArray(prefixArr, pattern);
		int i = 0;
		int j = 0;
		
		while (i < input.length() && j < pattern.length())
		{
			if (input.charAt(i) == pattern.charAt(j))
			{
				i++;
				j++;
			}
			else
			{
				if (j > 0)
				{
					j = prefixArr[j - 1];
				}
				else if (j == 0)
				{
					i++;
				}
			}
		}
		
		if (j == pattern.length())
		{
			return true;
		}
		
		return false;
	}
	
	void buildPrefixArray(int[] arr, String pattern)
	{
		int n = pattern.length();
		int i = 1;
		int j = 0;
		
		while (i < n)
		{
			if (pattern.charAt(i) == pattern.charAt(j))
			{
				arr[i] = j + 1;
				i++;
				j++;
			}
			else
			{
				if (j > 0)
				{
					j = arr[j - 1];
				}
				else if (j == 0)
				{
					arr[i] = 0;
					i++;
				}
			}			
		}
	}

	public static void main(String[] args) 
	{
		KMP obj = new KMP();
		System.out.println(obj.patternFound("abcdefasbcagsa", "asbg"));
		System.out.println(obj.patternFound("acacabacacabacacaXacacabacacabacacac","acacabacacabacacac"));
	}
}
