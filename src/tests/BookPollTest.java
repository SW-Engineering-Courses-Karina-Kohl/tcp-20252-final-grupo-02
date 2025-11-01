package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.BookPoll;

public class BookPollTest {

	@Test
	public void testBuilderBookPoll() {
		
		Date expectedClosingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(expectedClosingDate);
		
		assertNotNull(newBookPoll.getOpeningDate());
		assertEquals(expectedClosingDate, newBookPoll.getClosingDate());
		assertTrue(newBookPoll.getStatus());
		assertEquals(0, newBookPoll.getVotes().size());
		assertEquals(0, newBookPoll.getVoters().size());
		assertEquals(0, newBookPoll.getOptions().size());
		
	}

}
