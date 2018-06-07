
public class PushDominoes 
{
    public String pushDominoes(String dominoes) 
    {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int[] forces = new int[n];
        
        int force = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 'R')
                force = n;
            else if (arr[i] == 'L')
                force = 0;
            else
                force = Math.max(0, force - 1);     //force decay
            
            forces[i] += force;                     // +
        }
        
        force = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] == 'L')
                force = n;
            else if (arr[i] == 'R')
                force = 0;
            else
                force = Math.max(0, force - 1);     //force decay
            
            forces[i] -= force;                     // -
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            sb.append(forces[i] > 0 ? "R" : forces[i] < 0 ? "L" : ".");
        }
        return sb.toString();
    }

    public static void main(String[] args) 
    {
    	PushDominoes obj = new PushDominoes();
    	System.out.println(obj.pushDominoes(".L.R...LR..L.."));
	}
}
