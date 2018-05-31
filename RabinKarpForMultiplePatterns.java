
import java.util.HashMap;
import java.util.Map;

public class RabinKarpForMultiplePatterns 
{
	int seed = 101;									//Prime number chosen randomly
	void found(String input, String[] patterns)
	{
		int len = patterns[0].length();
		int hashPattern = 0;
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(String pattern : patterns)
		{
			hashPattern = computeHash(pattern, len);
			map.put(hashPattern, pattern);
		}
		
		int hashInput = computeHash(input, len);
		
		for(Map.Entry<Integer, String> entrySet: map.entrySet())
		{
			if(hashInput == entrySet.getKey())
				isMatch(input, 0, entrySet.getValue(), len);
		}
		
		for(int i = 1; i <= input.length() - len; i++)
		{
			hashInput = computeRollingHash(input, i, len, hashInput);

			for(Map.Entry<Integer, String> entrySet: map.entrySet())
			{
				if(hashInput == entrySet.getKey())
					isMatch(input, i, entrySet.getValue(), len);
			}
		}
	}
	
	void isMatch(String str, int offset, String pattern, int len)
	{
		int i = 0;
		
		while(offset < offset + len && i < len)
		{
			if(str.charAt(offset) != pattern.charAt(i))
				return;
			
			offset++;
			i++;
		}
		System.out.println("Found " + pattern);
	}
	
	int computeHash(String str, int len)
	{
		int hash = 0;
		
		for(int i = 0; i < len; i++)
		{
			hash += (int)(str.charAt(i) - 'a') * Math.pow(seed, i);
		}
		
		return hash;
	}
	
	int computeRollingHash(String str, int offset, int len, int prevHash)
	{
		prevHash -= (int)(str.charAt(offset - 1) - 'a');
		prevHash /= seed;
		prevHash += (int)(str.charAt(offset + len - 1)  - 'a') * Math.pow(seed, len - 1); 
		
		return prevHash;
	}
	
	public static void main(String[] args) 
	{
		RabinKarpForMultiplePatterns obj = new RabinKarpForMultiplePatterns();
		obj.found("abcdefasbcagsa", new String[] {"asb"});
		obj.found("abcgabcflmxyz", new String[] {"gab", "xyz", "aba"});
	}
}
