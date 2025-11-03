package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Creator;

public class CreatorTest {

	@Test
	public void testConstructor() {
		
		String name = "Matheus";
		String surname = "Candiotto";
		String email = "matheus.candiotto@ufrgs.br";
		String password = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(name, surname, email, password);
		
		assertEquals(1, newCreator.getId());
		assertEquals(name, newCreator.getName());
		assertEquals(surname, newCreator.getSurname());
		assertEquals(email, newCreator.getEmail());
		assertEquals(password, newCreator.getPassword());
		assertEquals(0, newCreator.getJoinedBookClubs().size());
		assertEquals(0, newCreator.getCreatedBookClubs().size());
		
	}

}
