package integration;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDecode {
	Gson gson = new Gson();
	private Collator collator;
	
	public JsonDecode(Collator collator){
		this.collator = collator;
	}
	
	public void decode(String stringJson){
		System.err.println(stringJson);
		JsonElement jelement = new JsonParser().parse(stringJson);
		JsonObject jObject = (JsonObject) jelement;
		JsonArray jarray = (JsonArray) jObject.get("vote_list");
		
		for(JsonElement vote:jarray){
			
			JsonObject oVote=(JsonObject) vote;
			
			String voter = oVote.get("voter").toString();
			String choice = oVote.get("choice").toString();
			
			collator.receive(voter, choice);
		}
	}
	
	
}
