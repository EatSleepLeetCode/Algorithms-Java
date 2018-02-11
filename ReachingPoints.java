import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class ReachingPoints 
{
	 // Solution 1 - Naive Recursion - TLE    
    /*
    public boolean reachingPoints(int sx, int sy, int tx, int ty) 
    {
        return helper(sx, sy, tx, ty);
    }
    
    boolean helper(int x, int y, int X, int Y)
    {
        if(x > X || y > Y)
            return false;
        if(x == X && y == Y)
            return true;
        
        return helper(x + y, y, X, Y) || helper(x, x + y, X, Y);
    }
    */
    
    // Solution 2 - DP - TLE
    /*
    boolean found = false;
	public boolean reachingPoints(int sx, int sy, int tx, int ty) 
    {
        Set<Points> seen = new HashSet<Points>();
        helper(new Points(sx, sy), tx, ty, seen);                
        return found;        
    }
	    
    void helper(Points p, int tx, int ty, Set<Points> seen)
    {
        if(found)
            return;
        if(seen.contains(p))
            return;
        if(p.x > tx || p.y > ty)
            return;

        if(p.x == tx && p.y == ty)
        {
            found = true;
            return;
        }

        seen.add(p);
        helper(new Points(p.x, p.x + p.y), tx, ty, seen);
        helper(new Points(p.x + p.y, p.y), tx, ty, seen);
    }

    class Points
    {
        int x;
        int y;

        public Points(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    */
    
    //Solution 3 - Work Backwards - TLE
    /*
    public boolean reachingPoints(int sx, int sy, int tx, int ty) 
    {
        while (tx >= sx && ty >= sy) 
        {
            if (sx == tx && sy == ty)
                return true;
            
            if (tx > ty) 
                tx -= ty;
            else 
                ty -= tx;
        }
        return false;
    }
    */
    
    //Solution 4 - Work Backwards with modulo
    public boolean reachingPoints(int sx, int sy, int tx, int ty) 
    {
        while (tx >= sx && ty >= sy) 
        {
            if (tx == ty) 
                break;
            
            if (tx > ty) 
            {
                if (ty > sy) 
                    tx %= ty;
                else 
                    return (tx - sx) % ty == 0;
            } 
            else 
            {
                if (tx > sx) 
                    ty %= tx;
                else 
                    return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }
	
	public static void main(String[] args) 
	{
		ReachingPoints obj = new ReachingPoints();
		System.out.println(obj.reachingPoints(1, 7, 3, 5));
	}
}
