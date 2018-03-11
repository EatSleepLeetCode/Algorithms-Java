public class ChampagneTower 
{
    public double champagneTower(int poured, int query_row, int query_glass) 
    {
        //notice 102 X 102 instead of 101 X 101 (there are 101 rows)
        double[][] glasses = new double[102][102]; 
        
        glasses[0][0] = (double)poured;
        double quantity = 0.0;
        
        for(int row = 0; row <= query_row; row++)
        {
            for(int col = 0; col <= row; col++)
            {
                quantity = (glasses[row][col] - 1.0) / 2.0;
                
                if(quantity > 0)
                {
                    glasses[row + 1][col] += quantity;
                    glasses[row + 1][col + 1] += quantity;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
	
    public static void main(String[] args) 
    {
    	ChampagneTower obj = new ChampagneTower();
    	System.out.println(obj.champagneTower(4, 2, 1));
    	System.out.println(obj.champagneTower(6, 2, 0));
	}
}