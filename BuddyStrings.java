class BuddyStrings 
{
    public boolean buddyStrings(String A, String B) 
    {
        int nA = A.length(), nB = B.length();
        int prevUnMatch = -1, count = 0;
        boolean isValid = false;
        int[] freq = new int[26];

        if (nA <= 1 || nB <= 1 || nA != nB) return false;
        
        for (int i = 0; i < nA; i++)
        {
            freq[A.charAt(i) - 'a']++;
            
            if (A.charAt(i) != B.charAt(i))
            {
                if (count == 2) return false;
                
                if (prevUnMatch == -1)
                {
                    prevUnMatch = i;
                    isValid = false;
                    count++;
                }
                else
                {
                    if (A.charAt(prevUnMatch) == B.charAt(i) && A.charAt(i) == B.charAt(prevUnMatch))
                        isValid = true;
                    else
                        return false;
                }
            }
        }
        
        if (isValid) return true;
        
        if (A.equals(B))                    //e.g. A = "aa" and B = "aa", we can swap a's
        {
            for (int i = 0; i < 26; i++)
            {
                if (freq[i] > 1) return true;
            }
        }
        
        return false;
    }
}
