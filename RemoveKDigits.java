
public class RemoveKDigits 
{
    public String removeKdigits(String num, int k) 
    {
        int n = num.length();
        char[] arr = new char[n];
        int resultN =  n - k;
        int top = 0;
        
        for (int i = 0; i < n; i++)
        {
            char ch = num.charAt(i);
            
            while (top > 0 && arr[top - 1] > ch && k > 0)
            {
                top--;
                k--;
            }
            
            arr[top] = ch;
            top++;
        }
        
        int index = 0;
        
        // find the index of first non-zero digit
        while (index < resultN && arr[index] == '0')
            index++;
        
        return index == resultN ? "0" : new String(arr, index, resultN - index);
    }
}
