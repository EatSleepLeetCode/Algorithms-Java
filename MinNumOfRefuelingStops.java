class MinNumOfRefuelingStops
{
    public int minRefuelStops(int target, int startFuel, int[][] stations) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        int prev = 0, result = 0;
        
        for (int[] station : stations)
        {
            int location = station[0];
            int capacity = station[1];
            
            if (target < location) return result;    //not required because target is > last station's loc
            
            startFuel -= location - prev;
            
            while (!pq.isEmpty() && startFuel < 0)  //must refuel in the past
            {
                startFuel += pq.poll();
                result++;
            }
            
            if (startFuel < 0) return -1;
            
            pq.offer(capacity);
            prev = location;
        }
        
        startFuel -= target - prev;

        while (!pq.isEmpty() && startFuel < 0)  //must refuel in the past
        {
            startFuel += pq.poll();
            result++;
        }

        if (startFuel < 0) return -1;
        return result;
    }
}
