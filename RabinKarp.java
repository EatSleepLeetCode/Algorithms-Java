
public class RabinKarp 
{
	int seed = 101;									//Prime number chosen randomly
	boolean found(String input, String pattern)
	{
		int len = pattern.length();
		int hashPattern = computeHash(pattern, len);
		int hashInput = computeHash(input, len);
		
		if(hashPattern == hashInput)
			return isMatch(input, 0, pattern, len);
		
		for(int i = 1; i <= input.length() - len; i++)
		{
			hashInput = computeRollingHash(input, i, len, hashInput);
			if(hashPattern == hashInput)
				return isMatch(input, i, pattern, len);			
		}

		return false;
	}
	
	boolean isMatch(String str, int offset, String pattern, int len)
	{
		int i = 0;
		
		while(offset < offset + len && i < len)
		{
			if(str.charAt(offset) != pattern.charAt(i))
				return false;
			
			offset++;
			i++;
		}
		return true;
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
		RabinKarp obj = new RabinKarp();
		System.out.println(obj.found("abcdefasbcagsa", "asb"));
		System.out.println(obj.found("abcgabcflmxyz", "gab"));
		System.out.println(obj.found("abcgabcflmxyz", "xyz"));
		System.out.println(obj.found("abcgabcflmxyz", "aba"));
	}
}
