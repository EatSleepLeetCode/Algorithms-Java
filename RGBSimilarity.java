
public class RGBSimilarity 
{
    public String similarRGB(String color) 
    {
        //Integer.parseInt(str, 16) could be used instead of manually converting to hex
        String a = getHex(getMin(Integer.parseInt(color.substring(1,3), 16)));
        String b = getHex(getMin(toHex(color.substring(3,5))));
        String c = getHex(getMin((toHex(color.substring(5)))));

        return  "#" + a + a + b + b + c + c;   
    }
    String getHex(int num)
    {
        if(num <= 9)
            return num + "";
        else
            return (char)(num - 10 + 'a') + "";
    }
    int getMin(int num)
    {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int minNum = 0;
        while(i < 16)
        {
            int cand = i * 16 + i;
            if(Math.abs(cand - num) < min)
            {
                min = Math.abs(cand - num);
                minNum = i;
            }
            i++;
        }
        return minNum;
    }
    int toHex(String str)
    {
        int result = 0;
        for(int i = 0 ; i < 2; i++)
        {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9')
                result = result * 16 + str.charAt(i) - '0';            
            else
                result = result * 16 + str.charAt(i) - 'a' + 10;
        }
        return result;
    }
	public static void main(String[] args) 
	{
		RGBSimilarity obj = new RGBSimilarity();
		System.out.println(obj.similarRGB("#09f166"));
	}
}
