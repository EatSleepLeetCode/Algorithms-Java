
public class ValidWordAbbreviation 
{
	boolean isValid(String word, String abbr)
	{
		int wordLength = word.length();
		int abbrLength = abbr.length();
		int i = 0, j = 0;
		
		while(i < wordLength && j < abbrLength)
		{
			int num = 0;
			if(Character.isDigit(abbr.charAt(j)))
			{
				num = abbr.charAt(j) - '0';
				j++;
				
				while(j < abbrLength && Character.isDigit(abbr.charAt(j)))
				{
					num = num * 10 + abbr.charAt(j) - '0';
					j++;
				}
				
				i += num;
			}
			else
			{
				if(word.charAt(i) != abbr.charAt(j))
					return false;
				i++;
				j++;
			}
		}
		return i == wordLength && j == abbrLength;
	}
	
	public static void main(String[] args) 
	{
		ValidWordAbbreviation obj = new ValidWordAbbreviation();
		System.out.println(obj.isValid("internationalization", "i18n"));
		System.out.println(obj.isValid("internationalization", "i12iz4n"));
		System.out.println(obj.isValid("apple", "a2e"));
	}
}
