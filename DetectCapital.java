class DetectCapital
{
    public boolean detectCapitalUse(String word) 
    {
        int n = word.length();               
        int capCount = 0;
        
        for (char ch : word.toCharArray())
        {
            if (Character.isUpperCase(ch)) capCount++;
        }
        
        return (capCount == 0 || capCount == n || (capCount == 1 && Character.isUpperCase(word.charAt(0))));
    }
    
    boolean isCapital(char ch)
    {
        return ch >= 65 && ch <= 90 ? true : false;
    }
}
