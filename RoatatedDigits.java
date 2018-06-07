import java.util.HashSet;
import java.util.Set;

public class RoatatedDigits 
{
	 public int rotatedDigits(int N) 
    {        
        Set<Character> valid = new HashSet<Character>();
        valid.add('0');
        valid.add('1');
        valid.add('8');
        valid.add('2');
        valid.add('5');
        valid.add('6');
        valid.add('9');
        
        int result = 0;
        
        for(int i = 1; i <= N; i++)
        {
            char[] input = String.valueOf(i).toCharArray();
            boolean flag = true;
            for(int j = 0; j < input.length; j++)
            {
            	if(!valid.contains(input[j]))
            	{
            		flag = false;
            		break;
            	}
            	
                if(input[j]  == '2')
                    input[j]  = '5';
                else if(input[j]  == '5')
                    input[j]  = '2';
                else if(input[j]  == '6')
                    input[j]  = '9';
                else if(input[j]  == '9')
                    input[j]  = '6';
            }
            
            if(flag && i != Integer.parseInt(new String(input)))
                result++;
        }
        return result;
    }
	 
	public static void main(String[] args) 
	{
		RoatatedDigits obj = new RoatatedDigits();
		System.out.println(obj.rotatedDigits(10));

	}

}
