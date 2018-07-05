class BinaryNumberWithAlternatingBits 
{
    public boolean hasAlternatingBits(int n) 
    {
        int prev = n & 1;
        
        while(n > 0)
        {            
            n = n >> 1;
            if ((n & 1) == prev) return false;            
            prev = n & 1;            
        }
        return true;
    }
}
