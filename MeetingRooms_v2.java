import java.util.Arrays;

public class MeetingRooms_v2 
{
	public int minMeetingRooms(Interval[] intervals)
	{
		int roomCount = 0;
		int prev = 0;
		int n = intervals.length;
		
		int[] startTimes = new int[n];
		int[] endTimes = new int[n];
		
		for (int i = 0; i < n ; i++)
		{
			startTimes[i] = intervals[i].start;
			endTimes[i] = intervals[i].end;
		}
		
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		
		for (int i = 0; i < n; i++)
		{
			roomCount++;
			
			if (startTimes[i] >= endTimes[prev])
			{
				roomCount--;
				prev++;
			}
		}
		return roomCount;
	}
	
	public static void main(String[] args) 
	{
		MeetingRooms_v2 obj = new MeetingRooms_v2();
		
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1,8);
		intervals[1] = new Interval(11,12);
		intervals[2] = new Interval(10,11);
		
		System.out.println(obj.minMeetingRooms(intervals));
	}
}

class Interval
{
	int start;
	int end;
	
	public Interval(int s, int e)
	{
		start = s;
		end = e;
	}
}