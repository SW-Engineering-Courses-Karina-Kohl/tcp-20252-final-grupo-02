package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.BookClub;
import main.Creator;

public class BookClubTest {

	@Test
	public void testConstructor() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String name = "Clube do Livro do Instituto de Informática da UFRGS";
		
		BookClub newBookClub = new BookClub(newCreator, name);
		
		assertEquals(1, newBookClub.getId());
		assertEquals(newCreator, newBookClub.getCreator());
		assertEquals(name, newBookClub.getName());
		assertEquals(0, newBookClub.getParticipants().size());
		assertEquals(0, newBookClub.getPolls().size());
		assertEquals(0, newBookClub.getMeetings().size());
		assertEquals(1, BookClub.getNumBookClubsCreated());
		
	}

}
