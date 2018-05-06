import java.util.ArrayList;
import java.util.List;

public class TextJustification 
{
    public List<String> fullJustify(String[] words, int L) 
    {
        int n = words.length, index = 0;
        List<String> lines = new ArrayList<String>();
        while (index < n) 
        {
            int count = words[index].length();
            int last = index + 1;
            
            while (last < n) 
            {
                if (words[last].length() + count + 1 > L) 
                    break;
                
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
               
            //if last line or 1 word in the line, left-justified
            if (last == n || diff == 0)  
            {
                for (int i = index + 1; i < last; i++) 
                {
                    builder.append(" ");
                    builder.append(words[i]);
                }
                
                for (int i = builder.length(); i < L; i++) 
                    builder.append(" ");
            }
            else 
            {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                
                for (int i = index + 1; i < last; i++) 
                {
                    for(int k = 1; k <= spaces; k++) 
                        builder.append(" ");
                    
                    if(r > 0) 
                    {
                        builder.append(" ");
                        r--;
                    }
                    
                    builder.append(" ");
                    builder.append(words[i]);
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }
    
    public static void main(String[] args) 
	{
		TextJustification obj = new TextJustification();
		obj.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);
	}
}
