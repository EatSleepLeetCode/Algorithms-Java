class ReverseStringII
{
    public String reverseStr(String s, int k) 
    {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        for (int left = 0; left < n; left += 2 * k)
        {
            int right = Math.min(left + k - 1, n - 1);            
            reverse(arr, left, right);
        }
        return String.valueOf(arr);
    }
    
    void reverse(char[] arr, int left, int right)
    {
        while (left < right)
        {
            char backup = arr[left];
            arr[left] = arr[right];
            arr[right] = backup;
            
            left++;
            right--;
        }
    }
}
