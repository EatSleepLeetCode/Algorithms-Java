import java.util.Arrays;

public class FindAndReplaceString 
{
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) 
    {
        int n = S.length();
        int[] match = new int[n];
        Arrays.fill(match, - 1);
        
        for (int i = 0; i < indexes.length; i++)
        {
            int index = indexes[i];
            int end = index + sources[i].length();              //Notice offset of "index" 
            
            if (S.substring(index, end).equals(sources[i]))
                match[index] = i;
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n)
        {
            if (match[i] >= 0)
            {
            	sb.append(targets[match[i]]);
            	i += sources[match[i]].length();			//Notice we use offset of "sources"
            }
            else
            {
            	sb.append(S.charAt(i));
            	i++;
            }
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) 
	{
		FindAndReplaceString obj = new FindAndReplaceString();
		System.out.println(obj.findReplaceString("abcd", new int[] {0,  2}, new String[] {"a", "cd"}, new String[] {"eee", "ffff"}));
	}
}
