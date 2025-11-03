package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.BookPoll;

public class BookPollTest {

	@Test
	public void testConstructor() {
		
		Date closingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(closingDate);
		
		assertNotNull(newBookPoll.getOpeningDate());
		assertEquals(closingDate, newBookPoll.getClosingDate());
		assertTrue(newBookPoll.getStatus());
		assertEquals(0, newBookPoll.getVotes().size());
		assertEquals(0, newBookPoll.getVoters().size());
		assertEquals(0, newBookPoll.getOptions().size());
		
	}

}
