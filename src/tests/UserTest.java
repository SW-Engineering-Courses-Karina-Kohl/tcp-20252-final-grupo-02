package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.User;

public class UserTest {

	@Test
	public void testBuilderUser() {
		
		String expectedName = "Matheus";
		String expectedSurname = "Candiotto";
		String expectedEmail = "matheus.candiotto@ufrgs.br";
		String expectedPassword = "SenhaMuitoSegura";
		
		User newUser = new User(expectedName, expectedSurname, expectedEmail, expectedPassword);
		
		assertEquals(1, newUser.getId());
		assertEquals(expectedName, newUser.getName());
		assertEquals(expectedSurname, newUser.getSurname());
		assertEquals(expectedEmail, newUser.getEmail());
		assertEquals(expectedPassword, newUser.getPassword());
		assertEquals(0, newUser.getJoinedBookClubs().size());
		assertEquals(1, User.getNumUsersCreated());
		
	}

}
