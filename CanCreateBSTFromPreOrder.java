import java.util.Stack;

public class CanCreateBSTFromPreOrder 
{
	boolean canCreate(int[] nums)
	{
		Stack<Integer> stack = new Stack<Integer>();
		int n = nums.length;
		int root = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++)
		{
			//If we find a node that is on right side and smaller than root, return false 
			if(nums[i] < root)
			{
				return false;
			}
			
			//If nums[i] is in right subtree of stack top, keep removing items 
			//smaller then nums[i] and make the last removed items as new root

			while(!stack.isEmpty() && stack.peek() < nums[i])
			{
				root = stack.pop();
			}
			
			stack.push(nums[i]);	//Either stack is empty or nums[i] < root, push nums[i] 
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		CanCreateBSTFromPreOrder obj = new CanCreateBSTFromPreOrder();
		System.out.println(obj.canCreate(new int[] {1, 2, 3}));
		System.out.println(obj.canCreate(new int[] {2, 1, 3}));
		System.out.println(obj.canCreate(new int[] {2, 3, 1}));		//Not possible to create
		System.out.println(obj.canCreate(new int[] {3, 1, 2}));
		System.out.println(obj.canCreate(new int[] {3, 2, 1}));
	}
}
