package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.BookPoll;


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
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createPoll(newBookPoll);
		
		assertEquals(1, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testDeleteBookPoll() {
		
		Date closingDate = new Date();
		
		BookPoll newBookPoll = new BookPoll(closingDate);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createPoll(newBookPoll);
		appSystem.deletePoll(newBookPoll);
		
		assertEquals(0, appSystem.getPolls().size());
		
	}

}
