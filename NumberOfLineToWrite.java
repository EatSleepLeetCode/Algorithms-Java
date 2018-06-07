
public class NumberOfLineToWrite 
{
    public int[] numberOfLines(int[] widths, String S) 
    {
        if(S.length() == 0)
        {
            return new int[]{0, 0};
        }
        
        char[] arr = S.toCharArray();
        int lineCount = 1;
        int currCount = 0;
        
        for(char ch : arr)
        {
            currCount += widths[ch - 'a'];
            if(currCount > 100)
            {
                lineCount++;
                currCount = widths[ch - 'a'];
            }
        }
        
        return new int[]{lineCount, currCount};
    }
	public static void main(String[] args) 
	{
		NumberOfLineToWrite obj = new NumberOfLineToWrite();
		System.out.println(obj.numberOfLines(new int[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz"));
	}
}
