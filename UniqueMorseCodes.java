import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodes 
{
    public int uniqueMorseRepresentations(String[] words) 
    {
        String[] mCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                                      "....","..",".---","-.-",".-..","--","-.",
                                      "---",".--.","--.-",".-.","...","-","..-",
                                      "...-",".--","-..-","-.--","--.."};
        
        Set<String> uniqueSets = new HashSet<String>();
        for(String word : words)
        {
            char[] arr = word.toCharArray();
            String str = "";
            for(int i = 0; i < arr.length; i++)
            {
                str += mCode[arr[i] - 'a'];
            }
            uniqueSets.add(str);
        }
        return uniqueSets.size();
    }

    public static void main(String[] args) 
    {
    	UniqueMorseCodes obj = new UniqueMorseCodes();
    	System.out.println(obj.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
	}
}
