package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.BookClub;
import com.Creator;

public class BookClubTest {

	@Test
	public void testBuilderBookClub() {
		
		Creator newCreator = new Creator("Matheus", "Candiotto", "matheus.candiotto@ufrgs.br", "SenhaMuitoSegura");
		
		String expectedName = "Clube do Livro do Instituto de Informática da UFRGS";
		
		BookClub newBookClub = new BookClub(newCreator, expectedName);
		
		assertEquals(1, newBookClub.getId());
		assertEquals(newCreator, newBookClub.getCreator());
		assertEquals(expectedName, newBookClub.getName());
		assertEquals(0, newBookClub.getParticipants().size());
		assertEquals(0, newBookClub.getPolls().size());
		assertEquals(0, newBookClub.getMeetings().size());
		assertEquals(1, BookClub.getNumBookClubsCreated());
		
	}

}
