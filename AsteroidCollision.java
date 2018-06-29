import java.util.Stack;

public class AsteroidCollision
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < n; i++)
        {
            if (stack.isEmpty() || asteroids[i] > 0)
            {
                stack.push(asteroids[i]);
                continue;
            }
            
            // if new asteroid is moving left
            while (true)
            {
                int prev = stack.peek();        //peek
                if (prev < 0)                   //if both are moving left, no collision
                {
                    stack.push(asteroids[i]);
                    break;
                }
                if (prev == -asteroids[i])      //if prev is moving right and has same size
                {
                    stack.pop();
                    break;
                }
                if (prev > -asteroids[i])       //if prev is moving right and has greater size
                {
                    break;
                }
                
                stack.pop();                    //if prev is moving right and has smaller size                
                if (stack.isEmpty())            //then push new asteroid to stack
                {
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }
        
        n = stack.size();
        int[] result = new int[n];
        n--;
        while (n >= 0)
        {
            result[n] = stack.pop();
            n--;
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        AsteroidCollision obj = new AsteroidCollision();
        obj.asteroidCollision(new int[] {5, 10, -5});
    }
}
