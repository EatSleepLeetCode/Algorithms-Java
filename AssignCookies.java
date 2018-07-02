class AssignCookies 
{
    public int findContentChildren(int[] greed, int[] cookieSize) 
    {
        Arrays.sort(cookieSize);
        Arrays.sort(greed);
        
        int i = 0;
        int j = 0;
        
        while (i < cookieSize.length && j < greed.length)
        {
            if (cookieSize[i] >= greed[j])
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        
        return j == greed.length ? greed.length : j;
    }
}
