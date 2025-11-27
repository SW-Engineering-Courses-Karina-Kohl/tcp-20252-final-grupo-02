package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.BookClub;
import com.Creator;
import com.AppSystem;

public class BookClubTest {
	
	@Test
	public void testConstructor() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String name = "Clube do Livro do Instituto de Informática da UFRGS";
		
		BookClub newBookClub = new BookClub(newCreator, name);
		
		assertEquals(BookClub.getNumBookClubsCreated(), newBookClub.getId());
		assertEquals(newCreator, newBookClub.getCreator());
		assertEquals(name, newBookClub.getName());
		assertEquals(0, newBookClub.getParticipants().size());
		assertEquals(0, newBookClub.getPolls().size());
		assertEquals(0, newBookClub.getMeetings().size());
		
	}

	@Test
	public void testCreateBookClub() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String name = "Clube do Livro do Instituto de Informática da UFRGS";
		
		BookClub newBookClub = new BookClub(newCreator, name);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createBookClub(newBookClub);
		
		assertEquals(1, appSystem.getBookClubs().size());
		
	}
	
	@Test
	public void testDeleteBookClub() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "012345678-90", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String name = "Clube do Livro do Instituto de Informática da UFRGS";
		
		BookClub newBookClub = new BookClub(newCreator, name);
		
		AppSystem appSystem = new AppSystem();
		
		appSystem.createBookClub(newBookClub);
		appSystem.deleteBookClub(newBookClub);
		
		assertEquals(0, appSystem.getBookClubs().size());
		
	}

}
