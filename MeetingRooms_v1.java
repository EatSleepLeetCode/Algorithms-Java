import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms_v1 
{
	public int minMeetingRooms(Interval[] intervals)
	{
		int roomCount = 0;
		int n = intervals.length;
		int max = Integer.MIN_VALUE;
		
		List<Node> intervalList = new ArrayList<Node>();
		
		for(int i = 0; i < n; i++)
		{
			intervalList.add(new Node(intervals[i].start, 0));
			intervalList.add(new Node(intervals[i].end, 1));
		}
		
		Collections.sort(intervalList, (a, b) -> a.val != b.val ? a.val - b.val : b.isEnd - a.isEnd);
		
		for(Node node : intervalList)
		{
			if(node.isEnd == 1)
			{
				roomCount--;
			}
			else
			{
				roomCount++;
			}
			
			max = Math.max(max, roomCount);
		}
		return max;
	}
	
	public static void main(String[] args)
	{
		MeetingRooms_v1 obj = new MeetingRooms_v1();
		
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

class Node
{
	int val;
	int isEnd;
	
	public Node(int val, int isEnd)
	{
	    this.val = val;
	    this.isEnd = isEnd;
	}
}