class RepeatedStringMatch
{
    public int repeatedStringMatch(String A, String B) 
    {
        String updA = A;
        
        for (int rep = 1; rep <= B.length() / A.length() + 2; rep++)    // <= (BLength / ALength) + 2
        {
            if (updA.indexOf(B) != -1)
                return rep;
            
            updA += A;
        }
        return -1;
    }
}
