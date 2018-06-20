import java.util.Arrays;

public class ValidSquare 
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) 
    {
        int[][] p = {p1, p2, p3, p4};
        
        //sort on x, if x is same then sort on y
        Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        
        return dist(p[0], p[1]) != 0 &&                     //2 points aren't same
               dist(p[0], p[1]) == dist(p[1], p[3]) &&      //compare length of 2 sides
               dist(p[1], p[3]) == dist(p[3], p[2]) &&      //compare length of 2 sides
               dist(p[3], p[2]) == dist(p[2], p[0]) &&      //compare length of 2 sides
               dist(p[0], p[3]) == dist(p[1], p[2]);        //compare length of 2 diagonals
    }
    
    double dist(int[] p1, int[] p2)
    {
        //Euclidean distance
        return Math.sqrt((p2[1] - p1[1]) * (p2[1] - p1[1]) + 
                         (p2[0] - p1[0]) * (p2[0] - p1[0]));
    }
}
