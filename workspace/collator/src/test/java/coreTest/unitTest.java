package coreTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


class Collator{

	private HashMap<String, String> listOfVotes = new HashMap<String, String>();

	public int getNumberOfVotes() {
		return listOfVotes.size();
	}

	public void receive(String voter, String candidate) {
		listOfVotes.put(voter,candidate);
	}

	public HashMap<String, Integer> getResults() {
		HashMap<String, Integer> countedResults = new HashMap<String, Integer>();
		
		int totalA = 0;
		int totalB = 0;
				
		for(Entry<String, String> entry : listOfVotes.entrySet()) {
		    String voter = entry.getKey();
		    String candidate = listOfVotes.get(voter);
		    if (!countedResults.keySet().contains(candidate)){
		    	countedResults.put(candidate, new Integer(1));
		    	continue;
		    }
		    Integer currentCount = countedResults.get(candidate);
		    Integer newCount= new Integer(currentCount.intValue() + 1);
		    countedResults.put(candidate, newCount);
		}
		return countedResults;
	}
	
}


public class unitTest {
	Collator collator;
	@Before
	public void setup(){
	 collator = new Collator();
	}
	
	
	@Test
	public void shouldReportOneVoteWhenOneVoteReceived(){
		//Arrange
		
		//Act
		collator.receive("Name of voter","Name of candidate");
		//Assert
		assertEquals(1,collator.getNumberOfVotes());
	}
	
	@Test
	public void shouldReturnCorrectTotalsWhenGivenVotes(){
		//Arrange

		//Act
		collator.receive("voter1","a");
		collator.receive("voter2","a");
		collator.receive("voter3","b");
		HashMap<String,Integer> result = collator.getResults();
		//Assert
		assertEquals(Integer.valueOf(2),(Integer) result.get("a"));
		assertEquals(Integer.valueOf(1),result.get("b"));
	}
	
}
