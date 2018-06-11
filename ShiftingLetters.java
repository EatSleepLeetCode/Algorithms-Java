
public class ShiftingLetters 
{
    public String shiftingLetters(String S, int[] shifts) 
    {
        int n = shifts.length;

        for (int i = 0; i < n; i++)
        {
            shifts[i] = shifts[i] % 26;                         //normalize shifts
        }
        
        for (int i = n - 2; i >= 0; i--)
        {
            shifts[i] += shifts[i + 1];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++)
        {
            sb.append(shift(S.charAt(i), shifts[i] % 26));      //re-normalize shift
        }
        
        return sb.toString();
    }
    
    char shift(char ch, int shift)
    {
        while (shift > 0)
        {
            ch += 1;
            
            if (ch > 'z')
                ch = 'a';
            
            shift--;
        }
        return ch;
    }
}
