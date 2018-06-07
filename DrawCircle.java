
public class DrawCircle 
{
	void printCircleCoordinates(int points, int radius, int[] center)
	{
		double slice = 2 * Math.PI / points;
		for(int i = 0; i < points; i++)
		{
			double angle = slice * i;
			int x = (int) (center[0] + radius * Math.cos(angle));
			int y = (int)(center[1] + radius * Math.sin(angle));
			System.out.println(x + " " + y);
		}
	}
	
	public static void main(String[] args) 
	{
		DrawCircle obj = new DrawCircle();
		obj.printCircleCoordinates(8, 2, new int[] {0, 0});
	}
}
