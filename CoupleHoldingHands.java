
public class CoupleHoldingHands 
{
    public int minSwapsCouples(int[] row) 
    {
        int result = 0;
        int n = row.length;
        int[] partner = new int[n];
        int[] pos = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            partner[i] = (i % 2 == 0 ? i + 1 : i - 1);
            pos[row[i]] = i;                            //x th person is sitting at i th position
        }
        
        for (int i = 0; i < n; i++)
        {
            int j = partner[pos[partner[row[i]]]];
            
            while (i != j)
            {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                j = partner[pos[partner[row[i]]]];
                result++;
            }
        }
        return result;
    }
    
    void swap(int[] arr, int i, int j)
    {
        int backup = arr[i];
        arr[i] = arr[j];
        arr[j] = backup;
    }
}
