
public class IsSubsequence 
{
    public boolean isSubsequence(String s, String t) 
    {
        int nS = s.length();        
        int nT = t.length();
        
        if (s.length() == 0)
            return true;
        
        int indexS = 0;
        int indexT = 0;
        
        while (indexS < nS && indexT < nT)
        {
            if (s.charAt(indexS) == t.charAt(indexT))
            {
                indexS++;
                indexT++;
            }
            else
            {
                indexT++;
            }
        }
        
        return indexS == nS;
    }
}
