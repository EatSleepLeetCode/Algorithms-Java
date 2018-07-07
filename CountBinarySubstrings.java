class CountBinarySubstrings
{
    public int countBinarySubstrings(String s) 
    {
        int prevLen = 0, currLen = 1, result = 0;
        
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
            {
                currLen++;
            }
            else
            {
                prevLen = currLen;
                currLen = 1;
            }
            
            if (prevLen >= currLen)
                result++;
        }        
        return result;
    }
}
