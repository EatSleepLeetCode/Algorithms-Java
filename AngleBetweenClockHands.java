
public class AngleBetweenClockHands 
{

	double findAngle(String time)
	{
		double angle = 0;
		String[] arr = time.split(":");
		int hour = Integer.parseInt(arr[0]);
		int mins = Integer.parseInt(arr[1]);
		
		if(hour == 12)
			hour = 0;
		if(mins == 60)
			mins = 0;
		
		//There are 360 degrees in 12 hours, 30 degrees in 1 hour or .5 degrees in 1 min
		//We also need to consider movement of mins hand because hour hand moves accordingly
		double hourHandAngle = 0.5 * (60 * hour + mins);
		
		//There are 360 degrees in 60 mins, 6 degrees in 1 min
		double minHandAngle = 6 * mins;	
		
		angle = Math.abs(hourHandAngle - minHandAngle);
		
		angle = Math.min(angle, 360 - angle);
		
		return angle;
	}
	
	public static void main(String[] args) 
	{
		AngleBetweenClockHands obj = new AngleBetweenClockHands();
		System.out.println(obj.findAngle("12:24"));
		System.out.println(obj.findAngle("08:30"));
		System.out.println(obj.findAngle("09:00"));
	}
}
