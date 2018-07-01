
public class NumberOfSegmentsInAString 
{
    //Solution 1 - O(n) space
    public int countSegments1(String s)
    {
        s = s.trim();
        if (s.equals("")) return 0;
        return s.split("\\s+").length;
    }
    
    //Solution 2 - O(1) space
    public int countSegments(String s)
    {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                count++;
        }
        return count;
    }
}
