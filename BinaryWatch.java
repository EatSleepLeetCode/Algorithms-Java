import java.util.ArrayList;
import java.util.List;

public class BinaryWatch 
{
    public List<String> readBinaryWatch(int num) 
    {
        List<String> result = new ArrayList<String>();
        
        for (int h = 0; h < 12; h++)
        {
            for (int m = 0; m < 60; m++)
            {
                if (Integer.bitCount(h * 64 + m) == num)		//Multiply by 64
                {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
