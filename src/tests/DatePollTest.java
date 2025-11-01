package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.DatePoll;

public class DatePollTest {

	@Test
	public void testBuilderDatePoll() {
		
		Date expectedClosingDate = new Date();
		
		DatePoll newDatePoll = new DatePoll(expectedClosingDate);
		
		assertNotNull(newDatePoll.getOpeningDate());
		assertEquals(expectedClosingDate, newDatePoll.getClosingDate());
		assertTrue(newDatePoll.getStatus());
		assertEquals(0, newDatePoll.getVotes().size());
		assertEquals(0, newDatePoll.getVoters().size());
		assertEquals(0, newDatePoll.getOptions().size());
		
	}

}
