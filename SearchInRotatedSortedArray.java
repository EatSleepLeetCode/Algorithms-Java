
public class SearchInRotatedSortedArray 
{
    public boolean search(int[] nums, int target) 
    {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid =0;
            
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            
            if(nums[mid] == target)
                return true;
         
            //Special case for duplicates
            if(nums[left] == nums[mid] && nums[mid] == nums[right])
            {
                left++;
                right--;
            }
            
            else if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target && nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else
            {
                if(nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
	
	public static void main(String[] args) 
	{
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {0,0,1,2,2,2,5,6}, 0));
		System.out.println(obj.search(new int[] {0,0,1,2,2,2,5,6}, 3));
	}
}
