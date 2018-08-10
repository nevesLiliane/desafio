package net.intelie.challenges;

import static org.junit.Assert.*;

import org.junit.Test;
import net.intelie.challenges.EventDAO;

public class EventStoreTest {

	@Test
	public void testInsert() {
		Event e = new Event("some", 22);
		EventDAO ed = new EventDAO();
		EventIterator ei = ed.query("some",0 , 23);
		ed.insert(e);
		assertNotEquals(ei, ed.query("some",0 , 23));
		
	}
	@Test
	public void testQuery() {
		EventDAO ed = new EventDAO();
		EventIterator ei = ed.query("some",0 , 230000);
		System.out.println(ei.toString());
		System.out.println(ed.query("some",0 , 230000).toString());
		assertEquals(ei, ed.query("some",0 , 230000));
	}
	@Test
	public void testRemoveAll() {
		EventDAO ed = new EventDAO();
		EventIterator ei = ed.query("some",0 , 230000);
		ed.removeAll("some");
		assertNotEquals(ei, ed.query("some",0 , 230000));
	}

	@Test
	public void testGetClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
