class MinimumIndexSumOfTwoLists
{
    public String[] findRestaurant(String[] list1, String[] list2) 
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> resultList = new ArrayList<String>();        
        int count = 0, minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < list1.length; i++)
        {
            if (!map.containsKey(list1[i]))
            {
                map.put(list1[i], i);
            }
        }
        
        for (int j = 0; j < list2.length; j++)
        {
            if (map.containsKey(list2[j]))
            {
                int currSum = j + map.get(list2[j]);
                
                if (currSum < minSum)
                {
                    minSum = currSum;
                    resultList.clear();
                    resultList.add(list2[j]);
                }
                else if (currSum == minSum)
                {
                    resultList.add(list2[j]);
                }
            }
        }
        
        return resultList.toArray(new String[resultList.size()]);
    }
}
