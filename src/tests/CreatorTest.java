package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Creator;

public class CreatorTest {

	@Test
	public void testBuilderCreator() {
		
		String expectedName = "Matheus";
		String expectedSurname = "Candiotto";
		String expectedEmail = "matheus.candiotto@ufrgs.br";
		String expectedPassword = "SenhaMuitoSegura";
		
		Creator newCreator = new Creator(expectedName, expectedSurname, expectedEmail, expectedPassword);
		
		assertEquals(1, newCreator.getId());
		assertEquals(expectedName, newCreator.getName());
		assertEquals(expectedSurname, newCreator.getSurname());
		assertEquals(expectedEmail, newCreator.getEmail());
		assertEquals(expectedPassword, newCreator.getPassword());
		assertEquals(0, newCreator.getJoinedBookClubs().size());
		assertEquals(0, newCreator.getCreatedBookClubs().size());
		
	}

}
