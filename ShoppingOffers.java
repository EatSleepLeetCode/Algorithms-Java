import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers 
{
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) 
    {
        return helper(price, special, needs, 0);
    }
    
    int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start)
    {
        int localMin = directPurchase(price, needs);
        
        for (int i = start; i < special.size(); i++)
        {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<Integer>();
            
            for (int j = 0; j < needs.size(); j++)
            {
                if (needs.get(j) < offer.get(j))        //we can't have more products than required
                {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            
            if (temp != null)   //use the current offer and try next
            {
                localMin = Math.min(localMin, offer.get(offer.size() - 1) + helper(price, special, temp, i));
            }
        }
        return localMin;
    }
    
    int directPurchase(List<Integer> price, List<Integer> needs)
    {
        int total = 0;
        for (int i = 0; i < needs.size(); i++)
        {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}
