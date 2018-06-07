
public class RotateString 
{
    public boolean rotateString(String A, String B) 
    {
        int nA = A.length();
        int nB = B.length();
        
        if(nA != nB)
            return false;
                
        for(int i = 0; i < nA; i++)
        {
            if(isSame(A, B, i))
            {
                return true;
            }
        }
        return false;
    }
    
    boolean isSame(String A, String B, int rotation)
    {
        for(int i = 0; i < A.length(); i++)
        {
            if(B.charAt(i) != A.charAt((i + rotation) % A.length()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {
    	RotateString obj = new RotateString();
    	System.out.println(obj.rotateString("abcde", "cdeab"));
	}
}
