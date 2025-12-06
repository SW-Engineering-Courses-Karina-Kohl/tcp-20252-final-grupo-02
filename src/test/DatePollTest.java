package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.DatePoll;
import com.User;
import com.AppSystem;

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
		
		DatePoll newDatePoll = new DatePoll(new Date());
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createPoll(newDatePoll);
		
		assertEquals(1, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testDeleteDatePoll() {
		
		DatePoll newDatePoll = new DatePoll(new Date());
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createPoll(newDatePoll);
		appSystem.deletePoll(newDatePoll);
		
		assertEquals(0, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testAddDateOption() {
		
		DatePoll newDatePoll = new DatePoll(new Date());
		
		Date newDate = new Date();
		
		assertEquals(0, newDatePoll.getOptions().size());
		
		newDatePoll.addDateOption(newDate);
		
		assertEquals(1, newDatePoll.getOptions().size());
		
		Date newSecondDateOption = new Date();
		
		newDatePoll.addDateOption(newSecondDateOption);
		
		assertEquals(2, newDatePoll.getOptions().size());
		
	}
	
	@Test
	public void testVoteDatePoll() {
		
		DatePoll newDatePoll = new DatePoll(new Date());
		
		Date newDate = new Date();
		
		newDatePoll.addDateOption(newDate);
		
		User newUser = new User("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		assertEquals(0, newDatePoll.getVotes().size());
		
		newDatePoll.vote(newUser, 0);
		assertEquals(1, newDatePoll.getVotes().size());
		
		newDatePoll.vote(newUser, 0);
		assertEquals(1, newDatePoll.getVotes().size());
		
		User newSecondUser = new User("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		newDatePoll.vote(newSecondUser, 0);
		assertEquals(2, newDatePoll.getVotes().size());
		
	}

}
