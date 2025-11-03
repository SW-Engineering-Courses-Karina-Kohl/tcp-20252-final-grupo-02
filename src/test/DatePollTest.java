package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.DatePoll;

public class DatePollTest {

	@Test
	public void testConstructor() {
		
		Date closingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(closingDate);
		
		assertNotNull(newDatePoll.getOpeningDate());
		assertEquals(closingDate, newDatePoll.getClosingDate());
		assertTrue(newDatePoll.getStatus());
		assertEquals(0, newDatePoll.getVotes().size());
		assertEquals(0, newDatePoll.getVoters().size());
		assertEquals(0, newDatePoll.getOptions().size());
		
	}

}
