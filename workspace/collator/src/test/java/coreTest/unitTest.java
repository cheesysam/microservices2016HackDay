package coreTest;

import org.junit.Test;

import integration.Collator;

import org.junit.Before;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;


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
