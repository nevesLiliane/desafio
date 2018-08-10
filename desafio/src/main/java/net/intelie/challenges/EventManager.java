package net.intelie.challenges;

import java.util.ArrayList;

public class EventManager implements EventIterator{

	ArrayList <Event> events;
    int posicao = 0;
     
    public EventManager(ArrayList <Event> events) {
        this.events = events;
    }

	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean moveNext() {
	     posicao++;
	     return posicao<events.size();
		
	}

	public Event current() {
		return events.get(posicao);
	}

	public void remove() {
		//events[posicao].
		events.remove(posicao);
	}

}
