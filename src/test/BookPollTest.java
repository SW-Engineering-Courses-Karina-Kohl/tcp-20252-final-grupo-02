package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.BookPoll;
import com.Main;

public class BookPollTest {

	@Test
	public void testConstructor() {
		
		Date closingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(closingDate);
		
		assertEquals(BookPoll.getNumPollsCreated(), newBookPoll.getId());
		assertNotNull(newBookPoll.getOpeningDate());
		assertEquals(closingDate, newBookPoll.getClosingDate());
		assertTrue(newBookPoll.getStatus());
		assertEquals(0, newBookPoll.getVotes().size());
		assertEquals(0, newBookPoll.getVoters().size());
		assertEquals(0, newBookPoll.getOptions().size());
		
	}
	
	@Test
	public void testCreateBookPoll() {
		
		Date closingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(closingDate);
		
		Main main = new Main();
		
		main.createPoll(newBookPoll);
		
		assertEquals(1, main.getPolls().size());
		
	}
	
	@Test
	public void testDeleteBookPoll() {
		
		Date closingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(closingDate);
		
		Main main = new Main();
		
		main.createPoll(newBookPoll);
		main.deletePoll(newBookPoll);
		
		assertEquals(0, main.getPolls().size());
		
	}

}
