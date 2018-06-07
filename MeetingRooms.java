import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms 
{
	public static void main(String[] args)
	{
		MeetingRooms obj = new MeetingRooms();
		
		Interval[] intervals = new Interval[4];
		intervals[0] = new Interval(1,8);
		intervals[1] = new Interval(2,15);
		intervals[2] = new Interval(4,5);
		intervals[3] = new Interval(10,11);
		
		System.out.println(obj.minMeetingRooms(intervals));
	}
	
	public int minMeetingRooms(Interval[] intervals)
	{
		int roomCount = 0;
		int n = intervals.length;
		int max = Integer.MIN_VALUE;
		
		List<Node> intervalList = new ArrayList<Node>();
		
		for(int i = 0; i < n; i++)
		{
			intervalList.add(new Node(intervals[i].start, false));
			intervalList.add(new Node(intervals[i].end, true));
		}
		
		Collections.sort(intervalList, new Comparator<Node>() {
			public int compare(Node node1, Node node2)
			{
				return node1.val - node2.val;
			}
		});
		
		for(Node node : intervalList)
		{
			if(!node.isEnd)
			{
				roomCount++;
			}
			else
			{
				roomCount--;
			}
			
			max = Math.max(max, roomCount);
		}
		return max;
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
	boolean isEnd;
	
	public Node(int val, boolean isEnd)
	{
	    this.val = val;
	    this.isEnd = isEnd;
	}
}