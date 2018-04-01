import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainVisitCount 
{
	public List<String> subdomainVisits(String[] cpdomains) 
    {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String cpdomain : cpdomains)
        {
            String[] cpdomainInfo = cpdomain.split(" ");
            int count = Integer.parseInt(cpdomainInfo[0]);
            String domain = cpdomainInfo[1];            
            map.put(domain, map.getOrDefault(domain, 0) + count);
            
            String[] domainPieces = domain.split("\\.");
            String curr = "";
            for(int i = domainPieces.length - 1; i > 0; i--)
            {                
                curr = domainPieces[i] + (curr.length() > 0 ? "." : "") + curr;
                map.put(curr, map.getOrDefault(curr, 0) + count);                
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
	public static void main(String[] args) 
	{
		DomainVisitCount obj = new DomainVisitCount();
		System.out.println(obj.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
		System.out.println(obj.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
	}

}
