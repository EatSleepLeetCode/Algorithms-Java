public class GuessNumber
{
    public int guessNumber(int n) 
    {
        int left = 1;
        int right = n;
        
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            
            if (guessResult > 0)            //guessed number is higher
                left = mid + 1;
            else if (guessResult < 0)       //guessed number is lower
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }
}
