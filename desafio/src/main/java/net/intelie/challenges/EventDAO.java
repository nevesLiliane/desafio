package net.intelie.challenges;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import net.intelie.challenges.adaptor.EventAdaptor;

public class EventDAO implements EventStore{
	
	public EventDAO() {
		// TODO Auto-generated constructor stub
	}
	

	public synchronized void insert(Event event) {
		// this method is synchronized because it cannot be stopped during execution for another method
			
		DB database = getClient().getDB("desafioIntelie");
		
		DBCollection events = database.getCollection("event");
		events.insert(EventAdaptor.toDBObject(event));
	}

	public synchronized void removeAll(String type) {
		/*
		 * If this procedure is called, it has to finish
		 */
		DB database = getClient().getDB("desafioIntelie");
		DBCollection events = database.getCollection("event");
		events.drop();
		
	}

	public EventIterator query(String type, long startTime, long endTime) {
		
		DB database = getClient().getDB("desafioIntelie");
		
		DBCollection events = database.getCollection("event");
		DBObject query = new BasicDBObject();
		query.put("type", type);
		query.put("timestamp", BasicDBObjectBuilder.start("$gte", startTime).add("$lte",endTime).get());
		DBCursor cursor = events.find(query);
		
		ArrayList <Event> eventArray= new ArrayList<Event>();
		if(cursor.hasNext()) {
			DBObject o = cursor.next();
			Event e = new Event((String) o.get("type"), (Long) o.get("timestamp"));
			eventArray.add(e);
		}

		return new EventManager(eventArray);
	}
	
	static MongoClient getClient() {
		return new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	}

}
