package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.Poll;

public class PollTest {

	@Test
	public void testConstructor() {
		
		Date closingDate = new Date();
		
		Poll newPoll = new Poll(closingDate);
		
		assertEquals(1, newPoll.getId());
		assertNotNull(newPoll.getOpeningDate());
		assertEquals(closingDate, newPoll.getClosingDate());
		assertTrue(newPoll.getStatus());
		assertEquals(0, newPoll.getVotes().size());
		assertEquals(0, newPoll.getVoters().size());
		assertEquals(1, Poll.getNumPollsCreated());
		
	}

}
