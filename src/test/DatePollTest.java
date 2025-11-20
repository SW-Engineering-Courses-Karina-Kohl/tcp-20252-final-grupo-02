package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.DatePoll;
import com.Main;

public class DatePollTest {

	@Test
	public void testConstructor() {
		
		Date closingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(closingDate);
		
		assertEquals(DatePoll.getNumPollsCreated(), newDatePoll.getId());
		assertNotNull(newDatePoll.getOpeningDate());
		assertEquals(closingDate, newDatePoll.getClosingDate());
		assertTrue(newDatePoll.getStatus());
		assertEquals(0, newDatePoll.getVotes().size());
		assertEquals(0, newDatePoll.getVoters().size());
		assertEquals(0, newDatePoll.getOptions().size());
		
	}
	
	@Test
	public void testCreateDatePoll() {
		
		Date closingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(closingDate);
		
		Main main = new Main();
		
		main.createPoll(newDatePoll);
		
		assertEquals(1, main.getPolls().size());
		
	}
	
	@Test
	public void testDeleteDatePoll() {
		
		Date closingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(closingDate);
		
		Main main = new Main();
		
		main.createPoll(newDatePoll);
		main.deletePoll(newDatePoll);
		
		assertEquals(0, main.getPolls().size());
		
	}

}
