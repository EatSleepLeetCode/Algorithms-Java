import java.util.ArrayList;
import java.util.List;

public class IPToCIDR 
{
    public List<String> ipToCIDR(String ip, int range) 
    {
        List<String> result = new ArrayList<String>();
        long num = ipToLong(ip);
        long mask = 0;

        while(range > 0)
        {
            mask = Math.max(33 - lowestOneBitPos(num), 33 - bitLength(range));
            result.add(longToIp(num) + "/" + mask);
            num += 1 << (32 - mask);
            range -= 1 << (32 - mask);
        }
        return result;
    }

    long ipToLong(String ip)
    {
        long result = 0;
        String[] ipArr = ip.split("\\.");

        for(String ipVal : ipArr)
        {
            result = result * 256 + Long.parseLong(ipVal);
        }
        return result;
    }


    String longToIp(long num)
    {
        String mask1 = (num >> 24) + ".";
        String mask2 = (num >> 16) % 256 + ".";
        String mask3 = (num >> 8) % 256 + ".";
        String mask4 = num % 256 + "";
        return mask1 + mask2 + mask3 + mask4;
    } 

    int lowestOneBitPos(long num)
    {
        int result = 1;
        if(num == 0)
            return 0;

        while(num > 0)
        {
            if((num & 1) == 1)
            {
                break;
            }
            num = num >> 1;
            result++;
        }
        return result;
    }

    int bitLength(int num)
    {
        int result = 0;
        if(num == 0)
            return 1;

        while(num > 0)
        {
            num = num >> 1;
            result++;
        }
        return result;
    }
    
	public static void main(String[] args) 
	{
		IPToCIDR obj = new IPToCIDR();
		obj.ipToCIDR("255.0.0.7", 10);
	}

}
