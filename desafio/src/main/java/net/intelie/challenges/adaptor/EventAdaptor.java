package net.intelie.challenges.adaptor;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import net.intelie.challenges.Event;

public class EventAdaptor {

	public static final DBObject toDBObject(Event event) {
	    return new BasicDBObject("timestamp", event.timestamp()).append("type", event.type());
	}

}
