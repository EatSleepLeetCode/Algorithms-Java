class PeakIndexInMountainArray
{
    //Solution 1: O(n)
    public int peakIndexInMountainArray1(int[] A) 
    {
        int i = 0;
        while (A[i] < A[i + 1])
        {
            i++;
        }
        return i;
    }
    
    //Solution 2: O(n log n)
    public int peakIndexInMountainArray(int[] A) 
    {
        int left = 0, right = A.length - 1;
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            
            if (A[mid] < A[mid + 1])
                left = mid + 1;
            else if (A[mid] > A[mid + 1])
                right = mid;
        }
        return left;
    }
}
