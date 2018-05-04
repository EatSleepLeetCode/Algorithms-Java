import java.util.ArrayList;
import java.util.List;

public class PermuationSequence 
{
	String getPermutation(int n, int k) 
	{
        List<Integer> numbers = new ArrayList<Integer>();
        int[] fact = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        fact[0] = 1;
        
        for(int i = 1; i < n; i++)
        {
            fact[i] = fact[i - 1] * i;
        }
        
        for(int i = 1; i <= n; i++)
        {
            numbers.add(i);
        }
        
        k--;
        
        for(int i = 1; i <= n; i++)
        {
            int index = k / fact[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k = k - index * fact[n - i];
        }
        return sb.toString();
    }

	public static void main(String[] args) 
	{
		PermuationSequence obj = new  PermuationSequence();
		System.out.println(obj.getPermutation(4, 14));
	}
}
