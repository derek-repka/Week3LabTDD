package cmput402.tdd;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;

public class Utility {

	public HashMap<String, Float> countAverageScore(Search search){
		
		HashMap<String, ArrayList<Integer>> results = search.returnAll();
		HashMap<String, Float> map = new HashMap<String, Float>();
		
		for(String player : results.keySet())
		{
			float avg = (float) results.get(player).get(1) / (float) results.get(player).get(0);
			map.put(player, avg);
		}
		
		return map;
	}
	
	public HashMap<String, Integer> findTopScorer(Search search){
		
		HashMap<String, ArrayList<Integer>> results = search.returnAll();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String highestScoringPlayer = "";
		Integer mostGoals = 0;
		
		for(String player : results.keySet())
		{
			Integer playGoals = results.get(player).get(1);
			if(playGoals >= mostGoals)
			{
				highestScoringPlayer = player;
				mostGoals = playGoals;
			}
		}
		
		map.put(highestScoringPlayer, mostGoals);
		return map;
	}
	
}
