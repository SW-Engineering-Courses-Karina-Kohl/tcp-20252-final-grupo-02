package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.AppSystem;
import com.Book;
import com.BookPoll;
import com.User;

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
		
		BookPoll newBookPoll = new BookPoll(new Date());
		
		AppSystem appSystem = new AppSystem();		
		appSystem.createPoll(newBookPoll);
		
		assertEquals(1, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testDeleteBookPoll() {
		
		BookPoll newBookPoll = new BookPoll(new Date());
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createPoll(newBookPoll);
		appSystem.deletePoll(newBookPoll);
		
		assertEquals(0, appSystem.getPolls().size());
		
	}
	
	@Test
	public void testAddBookOption() {

		BookPoll newBookPoll = new BookPoll(new Date());
		
		Book newBook = new Book("Admirável Mundo Novo", "Aldous Huxley", "9788-2505-0090", 2014, 312, "Ficção científica");
		
		assertEquals(0, newBookPoll.getOptions().size());
		
		newBookPoll.addBookOption(newBook);
		
		assertEquals(1, newBookPoll.getOptions().size());
		
		Book newSecondBook = new Book("Admirável Mundo Novo", "Aldous Huxley", "9788-2505-0090", 2014, 312, "Ficção científica");
		
		newBookPoll.addBookOption(newSecondBook);
		
		assertEquals(2, newBookPoll.getOptions().size());
		
	}
	
	@Test
	public void testVoteBookPoll() {
		
		BookPoll newBookPoll = new BookPoll(new Date());
		
		Book newBook = new Book("Admirável Mundo Novo", "Aldous Huxley", "9788-2505-0090", 2014, 312, "Ficção científica");
		
		newBookPoll.addBookOption(newBook);
		
		User newUser = new User("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		assertEquals(0, newBookPoll.getVotes().size());
		
		newBookPoll.vote(newUser, 0);
		assertEquals(1, newBookPoll.getVotes().size());
		
		newBookPoll.vote(newUser, 0);
		assertEquals(1, newBookPoll.getVotes().size());
		
		User newSecondUser = new User("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		newBookPoll.vote(newSecondUser, 0);
		assertEquals(2, newBookPoll.getVotes().size());
		
	}

}
