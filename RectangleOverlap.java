
public class RectangleOverlap 
{
    //Solution 1
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) 
    {
        int bottom1 = rec1[0];
        int left1 = rec1[1];
        int top1 = rec1[2];
        int right1 = rec1[3];
        
        int bottom2 = rec2[0];
        int left2 = rec2[1];
        int top2 = rec2[2];
        int right2 = rec2[3];
        
        if (left1 >= right2 || left2 >= right1)
            return false;
        if (bottom1 >= top2 || bottom2 >= top1)
            return false;
        
        return true;        
    }
    
    //Solution 2
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) 
    {
        int bottom1 = rec1[0];
        int left1 = rec1[1];
        int top1 = rec1[2];
        int right1 = rec1[3];
        
        int bottom2 = rec2[0];
        int left2 = rec2[1];
        int top2 = rec2[2];
        int right2 = rec2[3];
        
        if (Math.max(left1, left2) < Math.min(right1, right2) &&
            Math.max(bottom1, bottom2) < Math.min(top1, top2))
            return true;
        
        return false;
    }
}
