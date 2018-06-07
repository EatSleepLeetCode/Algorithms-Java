import java.util.Arrays;

public class MaximumGap 
{
	//Solution 1 - Bucket Sort
	public int maximumGapBucketSort(int[] nums) 
    {
        int n = nums.length;        
        if(n < 2) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            int num = nums[i];
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int gap = (int)Math.ceil((double)(max - min) / (n - 1));
        
        int[] bucketsMin = new int[n - 1];
        int[] bucketsMax = new int[n - 1];
        
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        
        for(int i = 0; i < n; i++)
        {
            int num = nums[i];
            
            if(num == min || num == max)
                continue;
            
            int index = (num - min) / gap;
            bucketsMin[index] = Math.min(bucketsMin[index], num);
            bucketsMax[index] = Math.max(bucketsMax[index], num);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        
        for(int i = 0; i < n - 1; i++)      //Notice:  < n - 1
        {
        	//empty bucket
            if(bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE)
                continue;
            
            //min value - previous value is current gap
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            
            //update previous bucket
            previous = bucketsMax[i];
        }
        
        //update the final max value gap
        maxGap = Math.max(maxGap, max - previous);
        
        return maxGap;
    }
	
    
	//Solution 2 - Radix Sort 
	 public int maximumGapRadixSort(int[] nums) 
	 {
	     int n = nums.length;        
	     if(n < 2) return 0;
	    
	     int max = Integer.MIN_VALUE;        
	     for(int i = 0; i < n; i++)
	     {
	         max = Math.max(max, nums[i]);
	     }
	    
	     int exp = 1; // 1, 10, 100, ...
	     int range = 10;  // 10 digits        
	     int[] aux = new int[n];
	     
	     while(max / exp > 0)
	     {
	         int[] count = new int[range];
	         
	         for(int i = 0; i < n; i++)
	         {
	             count[(nums[i] / exp) % 10]++;
	         }
	         
	         for(int i = 1; i < range; i++)      //Loop starts from 1
	         {
	             count[i] += count[i - 1];
	         }
	
	         for(int i = n - 1; i >= 0; i--)
	         {
	             count[(nums[i] / exp) % 10]--;
	             aux[count[(nums[i] / exp) % 10]] = nums[i];
	         }
	         
	         for(int i = 0; i < n; i++)
	         {
	             nums[i] = aux[i];
	         }
	         
	         exp *= 10;
	     }
	     
	     max = 0;
	     
	     for(int i = 1; i < aux.length; i++)
	     {
	         max = Math.max(max, aux[i] - aux[i - 1]);
	     }
	     
	     return max;
	 }   
    
    public static void main(String[] args) 
	{
    	MaximumGap obj = new MaximumGap();
    	int[] nums = new int[] {1, 5, 7, 9};
    	obj.maximumGapBucketSort(nums);
    	obj.maximumGapRadixSort(nums);
	}

}
