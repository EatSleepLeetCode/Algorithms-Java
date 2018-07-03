class DistributeCandies 
{
    public int distributeCandies(int[] candies) 
    {
        Set<Integer> unique = new HashSet<Integer>();
        
        for (int candy : candies)
            unique.add(candy);
        
        return Math.min(unique.size(), candies.length / 2);
    }
}
