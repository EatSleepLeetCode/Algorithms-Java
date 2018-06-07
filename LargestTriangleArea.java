
public class LargestTriangleArea 
{
    public double largestTriangleArea(int[][] points) 
    {
        double max = Double.MIN_VALUE;
        int n = points.length;
        
        for(int i = 0; i < n - 2; i++)
        {
            for(int j = i + 1; j < n -1; j++)
            {
                for(int k = j + 1; k < n; k++)
                {
                    max = Math.max(max, area(points, i, j, k));
                }
            }
        }
        return max;
    }
    
    double area(int[][] points, int i, int j, int k)
    {
        //x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)
        
        return Math.abs(0.5 * (points[i][0] * (points[j][1] - points[k][1]) + 
                               points[j][0] * (points[k][1] - points[i][1]) + 
                               points[k][0] * (points[i][1] - points[j][1]))); 
    }

	public static void main(String[] args) 
	{
		LargestTriangleArea obj = new LargestTriangleArea();
		System.out.println(obj.largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
	}
}
