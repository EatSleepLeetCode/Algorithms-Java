
public class SingleNumberIII 
{
    public int[] singleNumber(int[] nums) 
    {        
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        
        for(int num : nums)
        {
            diff = diff ^ num;
        }
        
        // Get its last set bit
        diff = diff & -diff;
        
        // Pass 2 :
        //Find the numbers
        int[] result = new int[2];
        
        for(int num : nums)
        {
            if((num & diff) == 0)           //if bit is not set
            {
                result[0] = result[0] ^ num;
            }
            else                            //if bit is set
            {
                result[1] = result[1] ^ num;
            }
        }
        return result;
    }
    
	public static void main(String[] args) 
	{
		SingleNumberIII obj = new SingleNumberIII();
		int[] nums = new int[] {1, 2, 1, 3, 2, 5};
		obj.singleNumber(nums);
	}
}
