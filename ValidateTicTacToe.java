
public class ValidateTicTacToe 
{
    public boolean validTicTacToe(String[] board) 
    {
        int pIndex = -1;
        int p1 = 0;
        int p2 = 0;
        boolean p1Won = false;
        boolean p2Won = false;
        int[][] rows = new int[2][3];
        int[][] cols = new int[2][3];
        int[][] diag = new int[2][2];
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                pIndex = -1;
                if(board[i].charAt(j) == 'X')
                {
                    pIndex = 0;    
                    p1++;
                }
                else if(board[i].charAt(j) == 'O')
                {
                    pIndex = 1;    
                    p2++;
                }
                
                if(pIndex < 0)      //Important
                    continue;
                
                rows[pIndex][i]++;
                cols[pIndex][j]++;

                if(i == j)
                    diag[pIndex][0]++;
                
                if(j == 3 - i - 1)  //Check reverse diag - Make sure it's not in ELSE of standard diag check
                    diag[pIndex][1]++;

                if(rows[pIndex][i] == 3 || cols[pIndex][j] == 3 || diag[pIndex][0] == 3 || diag[pIndex][1] == 3)
                {
                    if(pIndex == 0)
                        p1Won = true;
                    else
                        p2Won = true;
                }                    
            }
        }
        
        if(p1 < p2)                 //Player1's moves can't be less than Player2's moves
            return false;
        
        if(p1Won && p1 != p2 + 1)   //If P1 won then P1's moves should be exactly one more than P2
            return false;
        
        if(p2Won && p2 != p1)       //If P2 won then P1 and P2's moves should be equal
            return false;
                
        if(Math.abs(p1 - p2) > 1)   //Difference between P1 and P2's moves can't be greater than 1
            return false;
        
        return true;                //Otherwise, return true
    }
    
	public static void main(String[] args) 
	{
		ValidateTicTacToe obj = new ValidateTicTacToe();
		System.out.println(obj.validTicTacToe(new String[] {"O  ", "   ", "   "}));
	}
}
