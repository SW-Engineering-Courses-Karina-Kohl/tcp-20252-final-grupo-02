package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.model.DatePoll;

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
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createPoll(newDatePoll);
		
		assertEquals(1, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testDeleteDatePoll() {
		
		Date closingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(closingDate);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createPoll(newDatePoll);
		appSystem.deletePoll(newDatePoll);
		
		assertEquals(0, appSystem.getPolls().size());
		
	}

}
