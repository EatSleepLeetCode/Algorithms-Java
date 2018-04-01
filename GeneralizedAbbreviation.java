import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation 
{
	List<String> generateAbbreviations(String word)
	{
		List<String> result = new ArrayList<String>();
		result.add(word);
		helper(word, result, 0);
		return result;
	}
	
	void helper(String word, List<String> result, int start)
	{
		if(start == word.length())
			return;
		
		for(int i = start; i < word.length(); i++)
		{
			for(int j = 1; i + j <= word.length(); j++)
			{
				String abbr = word.substring(0,  i) + j + word.substring(i + j);
				result.add(abbr);
				helper(abbr, result, i + 1 + String.valueOf(j).length());
			}
		}
	}
	
	public static void main(String[] args) 
	{
		GeneralizedAbbreviation obj = new GeneralizedAbbreviation();
		System.out.println(obj.generateAbbreviations("word"));
	}
}
