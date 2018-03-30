
public class MedianOfTwoSortedArrays 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
    	int n = nums1.length;
    	int m = nums2.length;
    	int k = (n + m + 1) / 2;
    
    	int sum = getKth(nums1, 0, n - 1, nums2, 0, m - 1, k);
    	
    	if((n + m) % 2 == 0)
    	{
    		k = (n + m + 2) / 2;    		
    		sum += getKth(nums1, 0, n - 1, nums2, 0, m - 1, k);
    		return (double)sum / 2;
    	}
    	
    	return (double)sum;
    }
    
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) 
    {
    	int len1 = end1 - start1 + 1;
    	int len2 = end2 - start2 + 1;
    	if (len1 > len2) 
    		return getKth(nums2, start2, end2, nums1, start1, end1, k);
    	
    	if (len1 == 0) 
    		return nums2[start2 + k - 1];
    	
    	if (k == 1) 
    		return Integer.min(nums1[start1], nums2[start2]);
    	
    	int i = start1 + Integer.min(len1, k / 2) - 1;
    	int j = start2 + Integer.min(len2, k / 2) - 1;

    	//Eliminate the smaller half of the elements from one of the smaller arrays
    	if (nums1[i] > nums2[j]) 
    	{
    		return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
    	}
    	else 
    	{
    		return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    	}
    }
    
	public static void main(String[] args) 
	{
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		System.out.println(obj.findMedianSortedArrays(new int[] {2,3,7,8,10}, new int[] {1,3,5,6}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
	}
	
    void printArr(int[] arr, int start, int end)
    {
    	for(int i = start; i < end; i++)
    		System.out.print(arr[i] + " ");
    	System.out.println(" ");
    }
}
