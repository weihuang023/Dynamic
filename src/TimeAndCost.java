import java.util.ArrayList;
import java.util.List;

public class TimeAndCost {

	int time;
	int cost;

	
	public TimeAndCost (int time, int cost)
	{
		this.time = time;
		this.cost = cost;
	}
	
	public static TimeAndCost setTimeAndCost(int time, int cost)
	{
		return new TimeAndCost(time, cost);
	}
	
	public static List<TimeAndCost> getMiniCost()
	{
		int totalTime = 9;
		int time [] = {1,2,2,3,3,4};
		int cost [] = {9, 5, 10, 4, 9, 5};
		
		TimeAndCost Node0R1 = TimeAndCost.setTimeAndCost(time[0], cost[0]);
		TimeAndCost Node0R2 = TimeAndCost.setTimeAndCost(time[1], cost[1]);
		TimeAndCost Node1R1 = TimeAndCost.setTimeAndCost(time[2], cost[2]);
		TimeAndCost Node1R2 = TimeAndCost.setTimeAndCost(time[3], cost[3]);
		TimeAndCost Node2R1 = TimeAndCost.setTimeAndCost(time[4], cost[4]);
		TimeAndCost Node2R2 = TimeAndCost.setTimeAndCost(time[5], cost[5]);
		
		List<TimeAndCost> miniCost = new ArrayList<TimeAndCost>();
		
		miniCost.add(Node0R1);
		miniCost.add(Node0R2);
		miniCost.add(Node1R1);
		miniCost.add(Node1R2);
		miniCost.add(Node2R1);
		miniCost.add(Node2R2);
		
		int min = miniCost.get(0).cost;
		
		int size = miniCost.size();
		for(int i = 0; i< size; i++)
		{ 	
			for (int j =1; j< size;j++)
			{  
				
				min = Math.min(miniCost.get(i).cost,miniCost.get(j).cost + miniCost.get(i).cost);
				System.out.println("Min " +min);
		
			}
		}
		return miniCost;
	}
	
	public static void main(String[] arg){
		getMiniCost();
	}
}
