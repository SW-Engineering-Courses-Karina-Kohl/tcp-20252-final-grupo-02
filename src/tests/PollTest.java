package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.Poll;

public class PollTest {

	@Test
	public void testBuilderPoll() {
		
		Date expectedClosingDate = new Date();
		
		Poll newPoll = new Poll(expectedClosingDate);
		
		assertEquals(1, newPoll.getId());
		assertNotNull(newPoll.getOpeningDate());
		assertEquals(expectedClosingDate, newPoll.getClosingDate());
		assertTrue(newPoll.getStatus());
		assertEquals(0, newPoll.getVotes().size());
		assertEquals(0, newPoll.getVoters().size());
		assertEquals(1, Poll.getNumPollsCreated());
		
	}

}
