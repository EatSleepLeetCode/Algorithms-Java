
public class ConvertNumberToHexadecimal 
{
    public String toHex(int num) 
    {
        char[] arr = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        if (num == 0) return "0";
        
        String result = "";
        
        while (num != 0)
        {
            result = arr[(num & 15)] + result;  //15 is 1111
            num = num >>> 4;                    //Unsigned bit shift >>>
        }
        return result;
    }
}
